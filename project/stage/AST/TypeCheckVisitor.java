package AST;
import Semantic.*;
import Type.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TypeCheckVisitor implements Visitor{
  class FunctionHandle{
    public FunctionDecl fd;
  };

  class TypeExprTable{
    HashMap<String,Integer> typeIndices;
    HashMap<String,Integer> operationIndices;
    // operation, then lhs, then rhs
    ArrayList<List<List<Type>>> typeOperationTable;

    public void addTypeMapping(String operation, String leftType, String rightType, Type resultType){
      int operationIndex = operationIndices.get(operation);
      int leftTypeIndex = typeIndices.get(leftType);
      int rightTypeIndex = typeIndices.get(rightType);

      typeOperationTable.get(operationIndex).get(leftTypeIndex).set(rightTypeIndex, resultType);
    }

    public Type getTypeMapping(String operation, String leftType, String rightType){
      int operationIndex = operationIndices.get(operation);
      if(!typeIndices.containsKey(leftType)) return null;
      int leftTypeIndex = typeIndices.get(leftType);
      if(!typeIndices.containsKey(rightType)) return null;
      int rightTypeIndex = typeIndices.get(rightType);

      return typeOperationTable.get(operationIndex).get(leftTypeIndex).get(rightTypeIndex);
    }

    public TypeExprTable(){
      Type intType = new IntegerType();
      Type floatType = new FloatType();
      Type charType = new CharType();
      Type stringType = new StringType();
      Type booleanType = new BooleanType();
      Type voidType = new VoidType();

      typeIndices = new HashMap<String,Integer>();
      typeIndices.put(intType.toShortString(), 0);
      typeIndices.put(floatType.toShortString(), 1);
      typeIndices.put(charType.toShortString(), 2);
      typeIndices.put(stringType.toShortString(), 3);
      typeIndices.put(booleanType.toShortString(), 4);
      typeIndices.put(voidType.toShortString(), 5);

      operationIndices = new HashMap<String,Integer>();
      operationIndices.put("+", 0);
      operationIndices.put("-", 1);
      operationIndices.put("*", 2);
      operationIndices.put("<", 3);
      operationIndices.put("==", 4);
      operationIndices.put("sub", 5);

      int operationCount = operationIndices.size();
      int typeCount = typeIndices.size();

      typeOperationTable = new ArrayList<List<List<Type>>>();
      for(int i = 0; i < operationCount; i++){
        ArrayList<List<Type>> table = new ArrayList<List<Type>>();
        for(int j = 0; j < typeCount; j++){
          ArrayList<Type> types = new ArrayList<Type>();
          for(int k = 0; k < typeCount; k++){
            types.add(null);
          }
          table.add(types);
        }
        typeOperationTable.add(table);
      }

      // +
      addTypeMapping("+", intType.toShortString(), intType.toShortString(), intType);
      addTypeMapping("+", floatType.toShortString(), floatType.toShortString(), floatType);
      addTypeMapping("+", charType.toShortString(), charType.toShortString(), charType);
      addTypeMapping("+", stringType.toShortString(), stringType.toShortString(), stringType);

      // -
      addTypeMapping("-", intType.toShortString(), intType.toShortString(), intType);
      addTypeMapping("-", floatType.toShortString(), floatType.toShortString(), floatType);
      addTypeMapping("-", charType.toShortString(), charType.toShortString(), charType);

      // *
      addTypeMapping("*", intType.toShortString(), intType.toShortString(), intType);
      addTypeMapping("*", floatType.toShortString(), floatType.toShortString(), floatType);
      addTypeMapping("*", intType.toShortString(), floatType.toShortString(), floatType);
      addTypeMapping("*", floatType.toShortString(), intType.toShortString(), floatType);

      // <
      addTypeMapping("<", intType.toShortString(), intType.toShortString(), booleanType);
      addTypeMapping("<", floatType.toShortString(), floatType.toShortString(), booleanType);
      addTypeMapping("<", intType.toShortString(), floatType.toShortString(), booleanType);
      addTypeMapping("<", floatType.toShortString(), intType.toShortString(), booleanType);
      addTypeMapping("<", charType.toShortString(), charType.toShortString(), booleanType);
      addTypeMapping("<", stringType.toShortString(), stringType.toShortString(), booleanType);
      addTypeMapping("<", booleanType.toShortString(), booleanType.toShortString(), booleanType);

      // ==
      addTypeMapping("==", intType.toShortString(), intType.toShortString(), booleanType);
      addTypeMapping("==", floatType.toShortString(), floatType.toShortString(), booleanType);
      addTypeMapping("==", intType.toShortString(), floatType.toShortString(), booleanType);
      addTypeMapping("==", charType.toShortString(), charType.toShortString(), booleanType);
      addTypeMapping("==", stringType.toShortString(), stringType.toShortString(), booleanType);
      addTypeMapping("==", booleanType.toShortString(), booleanType.toShortString(), booleanType);

      // type equivalence
      addTypeMapping("sub", intType.toShortString(), intType.toShortString(), intType);
      addTypeMapping("sub", floatType.toShortString(), floatType.toShortString(), floatType);
      addTypeMapping("sub", charType.toShortString(), charType.toShortString(), charType);
      addTypeMapping("sub", stringType.toShortString(), stringType.toShortString(), stringType);
      addTypeMapping("sub", booleanType.toShortString(), booleanType.toShortString(), booleanType);
      addTypeMapping("sub", voidType.toShortString(), voidType.toShortString(), voidType);

      // subtypes (right is subtype of left)
      addTypeMapping("sub", floatType.toShortString(), intType.toShortString(), floatType);
    }
  };

  TypeExprTable typeExprTable;
  HashMap<String, FunctionHandle> ftable;
  Type currentFunctionType;
  HashMap<String, Type> vtable;
  public ArrayList<SemanticError> semanticErrors;

  void setVariable(Identifier id, Type type){
    if(type.toShortString().equals("void") ||
            (type instanceof ArrayType && ((ArrayType)type).baseType.equals(new VoidType()))
      ){
      semanticErrors.add(new SemanticError("variable cannot have void type", type.line, type.pos));
    }
    if(vtable.containsKey(id.name)){
      semanticErrors.add(new SemanticError("variable with name " + id.name + " cannot be redefined", id.line, id.pos));
    }
    vtable.put(id.name, type);
  }

  public Boolean visit(Program p){
    typeExprTable = new TypeExprTable();
    semanticErrors = new ArrayList<SemanticError>();

    ftable = new HashMap<String, FunctionHandle>();
    for(int i = 0; i < p.size(); i++){
        Function f = p.elementAt(i);
        FunctionHandle functionHandle = new FunctionHandle();
        FunctionDecl fd = f.functionDecl;
        functionHandle.fd = fd;
        if(ftable.containsKey(fd.id.name)){
          semanticErrors.add(new SemanticError("function with name " + fd.id.name + " cannot be defined twice", fd.id.line, fd.id.pos));
        }
        ftable.put(fd.id.name, functionHandle);
    }
    for(int i = 0; i < p.size(); i++){
      Function f = p.elementAt(i);
      f.accept(this);
    }
    FunctionHandle mainFunc = ftable.get("main");
    if(mainFunc == null){
      semanticErrors.add(new SemanticError("missing main function",-1,-1));
    }
    else{
      Type mainType = mainFunc.fd.type;
      if(!mainType.toShortString().equals("void")){
        int line = mainFunc.fd.type.line;
        int offset = mainFunc.fd.type.pos;
        semanticErrors.add(new SemanticError("main must be void", line, offset));
      }
      if(mainFunc.fd.params.size() > 0){
        Parameter firstParam = mainFunc.fd.params.getAt(0);
        int line = firstParam.type.line;
        int offset = firstParam.type.pos;
        semanticErrors.add(new SemanticError("main must not have parameters", line, offset));
      }
    }
    // TODO : sort by line number
    for(SemanticError error : semanticErrors){
      System.out.println(error.toString());
    }
    if(semanticErrors.size() == 0){
      return true;
    }
    return false;
  }

  public Type visit(Function f){
    // initialize vtable for function scope
    vtable = new HashMap<String, Type>();
    Type functionType = (Type)f.functionDecl.accept(this);
    f.functionBody.accept(this);
    return functionType;
  }

  public Type visit(FunctionDecl fd){
    currentFunctionType = fd.type;
    fd.params.accept(this);
    return fd.type;
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

  public Object visit(Type ct){return ct;}

  public Object visit(Identifier id){
    if(!vtable.containsKey(id.name)){
      semanticErrors.add(new SemanticError("reference to undefined variable " + id.name, id.line, id.pos));
      return null;
    }
    return vtable.get(id.name);
  }

  public Object visit(Parameter param){
    setVariable(param.id, param.type);
    return null;
  }

  public Object visit(ParameterList params){
    for(int i = 0; i < params.size(); i++){
      params.getAt(i).accept(this);
    }
    return null;
  }

  public Object visit(VarDecl vd){
      /*
    if(vd.type.equals(new VoidType()) || 
            (vd.type instanceof ArrayType && ((ArrayType)vd.type).baseType.equals(new VoidType()))
                ){
      semanticErrors.add(new SemanticError("invalid variable type", vd.id.line, vd.id.pos));
    }
    */
    setVariable(vd.id, vd.type);
    return null;
  }

  public Object visit(AssignStatement assignStatement){
    if(!vtable.containsKey(assignStatement.id.name)){
      semanticErrors.add(new SemanticError("assignment to undefined variable " + assignStatement.id.name, assignStatement.id.line, assignStatement.id.pos));
      return null;
    }
    Type lType = vtable.get(assignStatement.id.name);
    Type rType = (Type)assignStatement.expr.accept(this);
    if(rType != null && !lType.equals(rType) && typeExprTable.getTypeMapping("sub", lType.toShortString(), rType.toShortString()) == null){
      semanticErrors.add(new SemanticError("type mismatch in assign statement, cannot convert " + rType.toShortString() + " to " + lType.toShortString(), assignStatement.id.line, assignStatement.id.pos));
    }
    return null;
  }
  public Object visit(ArrayAssignStatement assignStatement){
    // check index is an int
    Type indexType = (Type)assignStatement.indexExpr.accept(this);
    if(!indexType.equals(new IntegerType())){
      semanticErrors.add(new SemanticError("invalid array assignment index type " + indexType.toShortString(), assignStatement.indexExpr.line, assignStatement.indexExpr.pos));
    }

    // check assignment
    if(!vtable.containsKey(assignStatement.id.name)){
      semanticErrors.add(new SemanticError("assignment to undefined variable " + assignStatement.id.name, assignStatement.id.line, assignStatement.id.pos));
      return null;
    }
    Type lType = (ArrayType)vtable.get(assignStatement.id.name);
    lType = ((ArrayType)lType).baseType;
    Type rType = (Type)assignStatement.assignExpr.accept(this);
    if(rType != null && !lType.equals(rType) && typeExprTable.getTypeMapping("sub", lType.toShortString(), rType.toShortString()) == null){
      semanticErrors.add(new SemanticError("type mismatch in assign statement, cannot convert " + rType.toShortString() + " to " + lType.toShortString(), assignStatement.id.line, assignStatement.id.pos));
    }
    return null;
  }

  public Object visit(ExprStatement exprStatement){
    Type type = (Type)exprStatement.expr.accept(this);
    return type;
  }
  public Object visit(IfStatement ifStatement){
    Type conditionType = (Type)ifStatement.condition.accept(this);
    if(conditionType == null) return null;
    Type booleanType = new BooleanType();
    if(typeExprTable.getTypeMapping("sub", conditionType.toShortString(), booleanType.toShortString()) == null){
      semanticErrors.add(new SemanticError("If condition must be boolean", ifStatement.condition.line, ifStatement.condition.pos));
    }
    ifStatement.ifBlock.accept(this);
    if(ifStatement.elseBlock != null){
        ifStatement.elseBlock.accept(this);
    }
    return conditionType;
  }
  public Object visit(WhileStatement whileStatement){
    Type conditionType = (Type)whileStatement.condition.accept(this);
    if(conditionType == null) return null;
    Type booleanType = new BooleanType();
    if(typeExprTable.getTypeMapping("sub", conditionType.toShortString(), booleanType.toShortString()) == null){
      semanticErrors.add(new SemanticError("While condition must be boolean", whileStatement.condition.line, whileStatement.condition.pos));
    }
    whileStatement.block.accept(this);
    return conditionType;
  }
  public Object visit(PrintStatement printStatement){
    Type exprType = (Type)printStatement.expr.accept(this);
    if(exprType != null && !exprType.equals(new IntegerType()) && !exprType.equals(new FloatType()) && !exprType.equals(new CharType()) && !exprType.equals(new StringType()) && !exprType.equals(new BooleanType())){
      semanticErrors.add(new SemanticError("Wrong type for print statement", printStatement.expr.line, printStatement.expr.pos));
    }
    return exprType;
  }
  public Object visit(PrintlnStatement printStatement){
    Type exprType = (Type)printStatement.expr.accept(this);
    if(exprType != null && !exprType.equals(new IntegerType()) && !exprType.equals(new FloatType()) && !exprType.equals(new CharType()) && !exprType.equals(new StringType()) && !exprType.equals(new BooleanType())){
      semanticErrors.add(new SemanticError("Wrong type for println statement", printStatement.expr.line, printStatement.expr.pos));
    }
    return exprType;
  }
  public Object visit(ReturnStatement returnStatement){
    if(returnStatement.expr == null){
      if(!currentFunctionType.equals(new VoidType())){
        semanticErrors.add(new SemanticError("Return statement needs expr of type " + currentFunctionType.toShortString(), returnStatement.line, returnStatement.pos));
      }
      return null;
    }
    Type exprType = (Type)returnStatement.expr.accept(this);
    if(!exprType.equals(currentFunctionType) && typeExprTable.getTypeMapping("sub", currentFunctionType.toShortString(), exprType.toShortString()) == null){
      semanticErrors.add(new SemanticError("Wrong type in return function", returnStatement.line, returnStatement.pos));
    }
    return exprType;
  }
  public Object visit(Block block){
    for(int i = 0; i < block.numStatements(); i++){
      block.statementAt(i).accept(this);
    }
    return null;
  }

  public Object visit(EqualsExpr expr){
    String operator = "==";
    Type lType = (Type)expr.left.accept(this);
    Type rType = (Type)expr.right.accept(this);
    if(lType == null || rType == null){
      return null;
    }
    Type resultType = typeExprTable.getTypeMapping(operator, lType.toShortString(), rType.toShortString());
    if(resultType == null){
      resultType = typeExprTable.getTypeMapping(operator, rType.toShortString(), lType.toShortString());
    }
    if(resultType == null){
      semanticErrors.add(new SemanticError("Cannot use operator " + operator + " on types " + lType.toShortString() + ", " + rType.toShortString(),expr.line,expr.pos));
    }
    return resultType;
  }
  public Object visit(LessThanExpr expr){
    String operator = "<";
    Type lType = (Type)expr.left.accept(this);
    Type rType = (Type)expr.right.accept(this);
    if(lType == null || rType == null){
      return null;
    }
    Type resultType = typeExprTable.getTypeMapping(operator, lType.toShortString(), rType.toShortString());
    if(resultType == null){
      semanticErrors.add(new SemanticError("Cannot use operator " + operator + " on types " + lType.toShortString() + ", " + rType.toShortString(),expr.line,expr.pos));
    }
    return resultType;
  }
  public Object visit(AddExpr expr){
    String operator = "+";
    Type lType = (Type)expr.left.accept(this);
    Type rType = (Type)expr.right.accept(this);
    if(lType == null || rType == null){
      return null;
    }
    Type resultType = typeExprTable.getTypeMapping(operator, lType.toShortString(), rType.toShortString());
    if(resultType == null){
      semanticErrors.add(new SemanticError("Cannot use operator " + operator + " on types " + lType.toShortString() + ", " + rType.toShortString(),expr.line,expr.pos));
    }
    return resultType;
  }
  public Object visit(SubtractExpr expr){
    String operator = "-";
    Type lType = (Type)expr.left.accept(this);
    Type rType = (Type)expr.right.accept(this);
    if(lType == null || rType == null){
      return null;
    }
    Type resultType = typeExprTable.getTypeMapping(operator, lType.toShortString(), rType.toShortString());
    if(resultType == null){
      semanticErrors.add(new SemanticError("Cannot use operator " + operator + " on types " + lType.toShortString() + ", " + rType.toShortString(),expr.line,expr.pos));
    }
    return resultType;
  }
  public Object visit(MultExpr expr){
    String operator = "*";
    Type lType = (Type)expr.left.accept(this);
    Type rType = (Type)expr.right.accept(this);
    if(lType == null || rType == null){
      return null;
    }
    Type resultType = typeExprTable.getTypeMapping(operator, lType.toShortString(), rType.toShortString());
    if(resultType == null){
      semanticErrors.add(new SemanticError("Cannot use operator " + operator + " on types " + lType.toShortString() + ", " + rType.toShortString(),expr.line,expr.pos));
    }
    return resultType;
  }

  public Object visit(StringLiteral stringLiteral){return new StringType();}
  public Object visit(CharLiteral charLiteral){return new CharType();}
  public Object visit(IntegerLiteral integerLiteral){return new IntegerType();}
  public Object visit(FloatLiteral floatLiteral){return new FloatType();}
  public Object visit(BooleanLiteral booleanLiteral){return new BooleanType();}

  public Object visit(ArrayReference arrayReference){
    // check index is an int
    Type indexType = (Type)arrayReference.expr.accept(this);
    if(indexType != null && !indexType.equals(new IntegerType())){
      semanticErrors.add(new SemanticError("invalid array assignment index type " + indexType.toShortString(), arrayReference.expr.line, arrayReference.expr.pos));
    }

    if(!vtable.containsKey(arrayReference.id.name)){
      semanticErrors.add(new SemanticError("reference to undefined identifier" + arrayReference.id.name, arrayReference.id.line, arrayReference.id.pos));
      return null;
    }
    Type idType = (ArrayType)vtable.get(arrayReference.id.name);
    idType = ((ArrayType)idType).baseType;
    return idType;
  }

  public Object visit(FunctionCall functionCall){
    Identifier id = functionCall.id;
    ExprList exprList = functionCall.exprList;

    if(!ftable.containsKey(id.name)){
      semanticErrors.add(new SemanticError("reference to undefined function " + id.name, id.line, id.pos));
      return null;
    }
    FunctionHandle fh = ftable.get(id.name);
    FunctionDecl fd = fh.fd;

    int i = 0;
    for(; i < fd.params.size(); i++){
      if(i >= exprList.size()){
        semanticErrors.add(new SemanticError("wrong number of parameters in call to function " + id.name, id.line, id.pos));
        continue;
      }
      Type p = fd.params.getAt(i).type;
      Type a = (Type)exprList.getAt(i).accept(this);
      if(a == null){
          continue;
      }
      if(!p.equals(a) && typeExprTable.getTypeMapping("sub", p.toShortString(), a.toShortString()) == null){
        semanticErrors.add(new SemanticError("cannot convert parameter of type " + a.toShortString() + " to type " + p.toShortString(), id.line, id.pos));
      }
    }
    if(i < exprList.size()){
      semanticErrors.add(new SemanticError("too many parameters in function call " + id.name, id.line, id.pos));
    }
    return fd.type;
  }

  // not used
  public Object visit(ExprList exprList){return null;}

  public Object visit(ParenExpr parenExpr){return parenExpr.innerExpr.accept(this);}
}
