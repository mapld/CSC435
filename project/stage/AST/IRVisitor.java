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
  IR ir;
  public Object visit(Program p){
    ir = new IR();
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
    return null;
  }
  public Object visit(FunctionDecl fd){
    IRType irType = (IRType)fd.type.accept(this);
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
    return null;
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
    int leftTemp = temporariesTable.get(assignStatement.id.name);
    int rightTemp = (Integer)assignStatement.expr.accept(this);
    IRAssignInstruction assignment = AssignmentFactory.createOperandAssignment(leftTemp, rightTemp);
    ir.addInstruction(assignment);
    return null;
  }
  public Object visit(ArrayAssignStatement assignStatement){
    int leftTemp = temporariesTable.get(assignStatement.id.name);
    int rightTemp = (Integer)assignStatement.assignExpr.accept(this);
    int indexTemp = (Integer)assignStatement.indexExpr.accept(this);
    IRAssignInstruction assignment = AssignmentFactory.createArrayAssignment(leftTemp, indexTemp, rightTemp);
    ir.addInstruction(assignment);
    return null;
  }
  public Object visit(ExprStatement exprStatement){
    exprStatement.expr.accept(this);
    return null;
  }
  public Object visit(IfStatement ifStatement){return null;}
  public Object visit(WhileStatement whileStatement){return null;}
  public Object visit(PrintStatement printStatement){
    int temporaryResult = (Integer)printStatement.expr.accept(this);
    IRBaseTypes baseType = ir.getTemporaryType(temporaryResult).baseType;
    IRPrintInstruction printInstruction = new IRPrintInstruction(false, baseType, temporaryResult);
    ir.addInstruction(printInstruction);
    return null;
  }
  public Object visit(PrintlnStatement printlnStatement){return null;}
  public Object visit(ReturnStatement returnStatement){return null;}
  public Object visit(Block block){return null;}
  public Object visit(EqualsExpr equalsExpr){return null;}
  public Object visit(LessThanExpr lessThanExpr){return null;}
  public Object visit(AddExpr lessThanExpr){return null;}
  public Object visit(SubtractExpr lessThanExpr){return null;}
  public Object visit(MultExpr multExpr){return null;}
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
  public Object visit(ArrayReference arrayReference){return null;}
  public Object visit(FunctionCall functionCall){return null;}
  public Object visit(ExprList exprList){return null;}
  public Object visit(ParenExpr parenExpr){return null;}
}
