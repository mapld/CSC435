package AST;
import Semantic.*;
import Type.*;
import IR.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class IRVisitor implements Visitor{
  Map<String, Integer> temporariesTable;
  Map<String, IRType> functionTypeTable;
  IR ir;
  String progName;
  IRType curFunctionReturnType;

  public IRVisitor(String progName){
    this.progName = progName;
  }

  public Object visit(Program p){
    functionTypeTable = new HashMap<String, IRType>();
    ir = new IR(progName);
    for(int i = 0; i < p.size(); i++){
      Function f = p.elementAt(i);
      IRType type = (IRType)f.functionDecl.type.accept(this);
      functionTypeTable.put(f.functionDecl.id.name, type);
      for(int j = 0; j < f.functionDecl.params.size(); j++){
        Parameter param = f.functionDecl.params.getAt(j);
        IRType currentType = (IRType)param.type.accept(this);
        functionTypeTable.put(f.functionDecl.id.name + j, currentType);
      }
    }
    for(int i = 0; i < p.size(); i++){
      Function f = p.elementAt(i);
      f.accept(this);
    }
    return ir;
  }
  public Object visit(Function f){
    // reset the temporaries table to empty
    temporariesTable = new HashMap<String, Integer>();

    f.functionDecl.accept(this);
    f.functionBody.accept(this);

    if(functionTypeTable.get(f.functionDecl.id.name).baseType == IRBaseTypes.VOID){
      IRReturnInstruction returnInst = new IRReturnInstruction();
      ir.addInstruction(returnInst);
    }
    if(functionTypeTable.get(f.functionDecl.id.name).baseType == IRBaseTypes.INT){
      int tempNum = ir.getTemporary(new IRType(IRBaseTypes.INT,false));
      IRAssignInstruction ci = AssignmentFactory.createConstantAssignment(tempNum, new IntegerLiteral(0,0,0));
      IRReturnInstruction returnInst = new IRReturnInstruction(tempNum);
      ir.addInstruction(ci);
      ir.addInstruction(returnInst);
    }
    return null;
  }
  public Object visit(FunctionDecl fd){
    IRType irType = (IRType)fd.type.accept(this);
    curFunctionReturnType = irType;
    // System.out.println(irType);
    ir.startFunction(fd.id.name, irType);

    fd.params.accept(this);
    // parse header
    return null;
  }
  public Object visit(FunctionBody fb){
    for(int i = 0; i < fb.numVars(); i++){
      fb.varAt(i).accept(this);
    }
    for(int i = 0; i < fb.numStatements(); i++){
      fb.statementAt(i).accept(this);
    }
    return null;
  }
  public Object visit(Type ct){
    return IRTools.typeToIRType(ct);
  }
  public Object visit(Identifier id){
    return temporariesTable.get(id.name);
  }

  public Object visit(ParameterList params){
    for(int i = 0; i < params.size(); i++){
      params.getAt(i).accept(this);
    }
    return null;
  }

  public Object visit(Parameter param){
    int tempNum = ir.addFunctionParam((IRType)param.type.accept(this));
    temporariesTable.put(param.id.name, tempNum);
    // System.out.println("name: " + param.id.name + ", temp num: " + temporariesTable.get(param.id.name));
    return null;
  }

  public Object visit(VarDecl vd){
    int tempNum = ir.getTemporary((IRType)vd.type.accept(this));
    temporariesTable.put(vd.id.name, tempNum);
    if(vd.type instanceof ArrayType){
      ArrayType arrType = (ArrayType)vd.type;
      IRAssignInstruction arrInstruction = AssignmentFactory.createNewArrayAssignment(tempNum,
                                                                                      (IRType)arrType.baseType.accept(this),
                                                                                      arrType.arraySize
                                                                                      );
      ir.addInstruction(arrInstruction);
    }
    return null;
  }
  public Object visit(AssignStatement assignStatement){
    // whatever is on the right of the assign statement will be visited and put its result in a temporary which will be returned
    MutInt leftTemp = new MutInt(temporariesTable.get(assignStatement.id.name));
    MutInt rightTemp = new MutInt((Integer)assignStatement.expr.accept(this));
    IRType type = convertTypes(leftTemp, rightTemp);

    IRAssignInstruction assignment = AssignmentFactory.createOperandAssignment(leftTemp.value, rightTemp.value);
    ir.addInstruction(assignment);
    return null;
  }
  public Object visit(ArrayAssignStatement assignStatement){
    MutInt leftTemp = new MutInt(temporariesTable.get(assignStatement.id.name));
    MutInt rightTemp = new MutInt((Integer)assignStatement.assignExpr.accept(this));
    int indexTemp = (Integer)assignStatement.indexExpr.accept(this);
    IRAssignInstruction assignment = AssignmentFactory.createArrayAssignment(leftTemp.value, indexTemp, rightTemp.value);
    ir.addInstruction(assignment);
    return null;
  }
  public Object visit(ExprStatement exprStatement){
    exprStatement.expr.accept(this);
    return null;
  }
  public Object visit(IfStatement ifStatement){
    int conditionTemp = (Integer)ifStatement.condition.accept(this);
    IRType type = new IRType(IRBaseTypes.BOOLEAN, false);
    int invertedTemp = ir.getTemporary(type);
    IRAssignInstruction invertInst = AssignmentFactory.createUnaryOp("!", type, invertedTemp, conditionTemp);
    ir.addInstruction(invertInst);

    // invertedTemp now holds the reverse of the if statement (if true jump forward)
    int elseLabel = -1;
    if(ifStatement.elseBlock != null){
      elseLabel = ir.getLabel();
    }
    int afterLabel = ir.getLabel();

    IRJumpInstruction jumpInst;
    if(elseLabel >= 0){
      jumpInst = new IRJumpInstruction(elseLabel, invertedTemp);
    }
    else{
      jumpInst = new IRJumpInstruction(afterLabel, invertedTemp);
    }
    ir.addInstruction(jumpInst);

    ifStatement.ifBlock.accept(this);


    if(ifStatement.elseBlock != null){
      IRJumpInstruction afterElseJumpInst = new IRJumpInstruction(afterLabel);
      ir.addInstruction(afterElseJumpInst);
      IRLabelInstruction elseLabelInst = new IRLabelInstruction(elseLabel);
      ir.addInstruction(elseLabelInst);
      ifStatement.elseBlock.accept(this);
    }

    IRLabelInstruction labelInst = new IRLabelInstruction(afterLabel);
    ir.addInstruction(labelInst);

    return null;
  }

  public Object visit(WhileStatement whileStatement){
    // first label goes before condition checking
    int firstLabel = ir.getLabel();
    int endLabel = ir.getLabel();
    IRLabelInstruction firstLabelInst = new IRLabelInstruction(firstLabel);
    ir.addInstruction(firstLabelInst);

    int conditionTemp = (Integer)whileStatement.condition.accept(this);
    IRType type = new IRType(IRBaseTypes.BOOLEAN, false);
    int invertedTemp = ir.getTemporary(type);
    IRAssignInstruction invertInst = AssignmentFactory.createUnaryOp("!", type, invertedTemp, conditionTemp);
    ir.addInstruction(invertInst);

    IRJumpInstruction toEndJumpInst = new IRJumpInstruction(endLabel, invertedTemp);
    ir.addInstruction(toEndJumpInst);
    whileStatement.block.accept(this);
    IRJumpInstruction toStartJumpInst = new IRJumpInstruction(firstLabel);
    ir.addInstruction(toStartJumpInst);

    IRLabelInstruction endLabelInst = new IRLabelInstruction(endLabel);
    ir.addInstruction(endLabelInst);
    return null;
  }

  public Object visit(PrintStatement printStatement){
    int temporaryResult = (Integer)printStatement.expr.accept(this);
    IRBaseTypes baseType = ir.getTemporaryType(temporaryResult).baseType;
    IRPrintInstruction printInstruction = new IRPrintInstruction(false, baseType, temporaryResult);
    ir.addInstruction(printInstruction);
    return null;
  }
  public Object visit(PrintlnStatement printlnStatement){
    int temporaryResult = (Integer)printlnStatement.expr.accept(this);
    IRBaseTypes baseType = ir.getTemporaryType(temporaryResult).baseType;
    IRPrintInstruction printInstruction = new IRPrintInstruction(true, baseType, temporaryResult);
    ir.addInstruction(printInstruction);
    return null;
  }
  public Object visit(ReturnStatement returnStatement){
    int returnOperand = -1;
    IRType returnType;
    if(returnStatement.expr != null){
      returnOperand = (Integer)returnStatement.expr.accept(this);
      returnType = ir.getTemporaryType(returnOperand);
      if(returnType.baseType == IRBaseTypes.INT && curFunctionReturnType.baseType == IRBaseTypes.FLOAT){
           int assignTemp = ir.getTemporary(IRBaseTypes.FLOAT);
           IRAssignInstruction convertInst = AssignmentFactory.createConversion(returnType, curFunctionReturnType, returnOperand, assignTemp);
           ir.addInstruction(convertInst);
           returnOperand = assignTemp;
      }

    }

    
    IRReturnInstruction returnInst;
    if(returnOperand >= 0){
      returnInst = new IRReturnInstruction(returnOperand);
    }
    else{
      returnInst = new IRReturnInstruction();
    }
    ir.addInstruction(returnInst);
    return null;
  }
  public Object visit(Block block){
    for(int i = 0; i < block.numStatements(); i++){
      block.statementAt(i).accept(this);
    }
    return null;
  }

  class MutInt{
    public int value;
    public MutInt(int value){
      this.value = value;
    }
  }

  IRType convertTypes(MutInt leftTemp, MutInt rightTemp){
    IRType leftType = ir.getTemporaryType(leftTemp.value);
    IRType rightType = ir.getTemporaryType(rightTemp.value);
    if(leftType.baseType == IRBaseTypes.FLOAT && rightType.baseType == IRBaseTypes.INT){
      int assignTemp = ir.getTemporary(IRBaseTypes.FLOAT);
      IRAssignInstruction convertInst = AssignmentFactory.createConversion(rightType, leftType, rightTemp.value, assignTemp);
      ir.addInstruction(convertInst);
      rightTemp.value = assignTemp;
      return leftType;
    }
    else if(rightType.baseType == IRBaseTypes.FLOAT && leftType.baseType == IRBaseTypes.INT){
      int assignTemp = ir.getTemporary(IRBaseTypes.FLOAT);
      IRAssignInstruction convertInst = AssignmentFactory.createConversion(leftType, rightType, leftTemp.value, assignTemp);
      ir.addInstruction(convertInst);
      leftTemp.value = assignTemp;
      return rightType;
    }
    return leftType;
  }

  public Object visit(EqualsExpr equalsExpr){
    MutInt leftTemporary = new MutInt((Integer)equalsExpr.left.accept(this));
    MutInt rightTemporary = new MutInt((Integer)equalsExpr.right.accept(this));
    IRType type = convertTypes(leftTemporary, rightTemporary);

    int assignTemporary = ir.getTemporary(IRBaseTypes.BOOLEAN);
    IRAssignInstruction equalsInst = AssignmentFactory.createBinaryOp("==", type, assignTemporary, leftTemporary.value, rightTemporary.value);
    ir.addInstruction(equalsInst);
    return assignTemporary;
  }
  public Object visit(LessThanExpr lessThanExpr){
    MutInt leftTemporary = new MutInt((Integer)lessThanExpr.left.accept(this));
    MutInt rightTemporary = new MutInt((Integer)lessThanExpr.right.accept(this));
    IRType type = convertTypes(leftTemporary, rightTemporary);
    int assignTemporary = ir.getTemporary(IRBaseTypes.BOOLEAN);
    IRAssignInstruction equalsInst = AssignmentFactory.createBinaryOp("<", type, assignTemporary, leftTemporary.value, rightTemporary.value);
    ir.addInstruction(equalsInst);
    return assignTemporary;
  }
  public Object visit(AddExpr addExpr){
    MutInt leftTemporary = new MutInt((Integer)addExpr.left.accept(this));
    MutInt rightTemporary = new MutInt((Integer)addExpr.right.accept(this));
    IRType type = convertTypes(leftTemporary, rightTemporary);
    int assignTemporary = ir.getTemporary(type);
    IRAssignInstruction equalsInst = AssignmentFactory.createBinaryOp("+", type, assignTemporary, leftTemporary.value, rightTemporary.value);
    ir.addInstruction(equalsInst);
    return assignTemporary;
  }
  public Object visit(SubtractExpr subtractExpr){
    MutInt leftTemporary = new MutInt((Integer)subtractExpr.left.accept(this));
    MutInt rightTemporary = new MutInt((Integer)subtractExpr.right.accept(this));
    IRType type = convertTypes(leftTemporary, rightTemporary);
    int assignTemporary = ir.getTemporary(type);
    IRAssignInstruction equalsInst = AssignmentFactory.createBinaryOp("-", type, assignTemporary, leftTemporary.value, rightTemporary.value);
    ir.addInstruction(equalsInst);
    return assignTemporary;
  }
  public Object visit(MultExpr multExpr){
    MutInt leftTemporary = new MutInt((Integer)multExpr.left.accept(this));
    MutInt rightTemporary = new MutInt((Integer)multExpr.right.accept(this));
    IRType type = convertTypes(leftTemporary, rightTemporary);
    int assignTemporary = ir.getTemporary(type);
    IRAssignInstruction equalsInst = AssignmentFactory.createBinaryOp("*", type, assignTemporary, leftTemporary.value, rightTemporary.value);
    ir.addInstruction(equalsInst);
    return assignTemporary;
  }
  public Object visit(StringLiteral stringLiteral){
    int temporary = ir.getTemporary(IRBaseTypes.STRING);
    IRAssignInstruction constantAssignment = AssignmentFactory.createConstantAssignment(temporary, stringLiteral);
    ir.addInstruction(constantAssignment);
    return temporary;
  }
  public Object visit(CharLiteral charLiteral){
    int temporary = ir.getTemporary(IRBaseTypes.CHAR);
    IRAssignInstruction constantAssignment = AssignmentFactory.createConstantAssignment(temporary, charLiteral);
    ir.addInstruction(constantAssignment);
    return temporary;
  }

  public Object visit(IntegerLiteral intLiteral){
    int temporary = ir.getTemporary(IRBaseTypes.INT);
    IRAssignInstruction constantAssignment = AssignmentFactory.createConstantAssignment(temporary, intLiteral);
    ir.addInstruction(constantAssignment);
    return temporary;
  }
  public Object visit(FloatLiteral floatLiteral){
    int temporary = ir.getTemporary(IRBaseTypes.FLOAT);
    IRAssignInstruction constantAssignment = AssignmentFactory.createConstantAssignment(temporary, floatLiteral);
    ir.addInstruction(constantAssignment);
    return temporary;
  }
  public Object visit(BooleanLiteral booleanLiteral){
    int temporary = ir.getTemporary(IRBaseTypes.BOOLEAN);
    IRAssignInstruction constantAssignment = AssignmentFactory.createConstantAssignment(temporary, booleanLiteral);
    ir.addInstruction(constantAssignment);
    return temporary;
  }
  public Object visit(ArrayReference arrayReference){
    int indexTemporary = (Integer)arrayReference.expr.accept(this);
    int rightTemporary = temporariesTable.get(arrayReference.id.name);
    IRType type = new IRType(ir.getTemporaryType(rightTemporary).baseType, false);
    int leftTemporary = ir.getTemporary(type);
    IRAssignInstruction assignment = AssignmentFactory.createAssignmentFromArray(leftTemporary, rightTemporary, indexTemporary);
    ir.addInstruction(assignment);
    return leftTemporary;
  }
  public Object visit(FunctionCall functionCall){
    List<Integer> operands = (List<Integer>)functionCall.exprList.accept(this);
    List<Integer> newOperands = new ArrayList<Integer>();

    for(int i = 0; i < operands.size(); i++){
      IRType paramType = functionTypeTable.get(functionCall.id.name + i);
      IRType callParamType = ir.getTemporaryType(operands.get(i));
      int assignTemp = ir.getTemporary(IRBaseTypes.FLOAT);
      if(paramType.baseType == IRBaseTypes.FLOAT && callParamType.baseType == IRBaseTypes.INT){
        IRAssignInstruction convertInst = AssignmentFactory.createConversion(callParamType, paramType, operands.get(i), assignTemp);
        ir.addInstruction(convertInst);
        newOperands.add(assignTemp);
      }
      else{
        newOperands.add(operands.get(i));
      }
    }

    operands = newOperands;

    IRType returnType = functionTypeTable.get(functionCall.id.name);
    IRCallInstruction callInst;
    int assignOperand = -1;
    if(returnType.baseType == IRBaseTypes.VOID){
      callInst = new IRCallInstruction(functionCall.id.name, operands);
    }
    else{
      assignOperand = ir.getTemporary(returnType);
      callInst = new IRCallInstruction(functionCall.id.name, operands, assignOperand);
    }
    ir.addInstruction(callInst);
    return assignOperand;
  }
  public Object visit(ExprList exprList){
    List<Integer> operands = new ArrayList<Integer>();
    for(int i = 0; i < exprList.size(); i++){
      Expr expr = exprList.getAt(i);
      int operand = (Integer)expr.accept(this);
      operands.add(operand);
    }
    return operands;
  }
  public Object visit(ParenExpr parenExpr){
    return parenExpr.innerExpr.accept(this);
  }
}
