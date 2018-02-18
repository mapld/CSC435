package AST;
import Semantic.*;
import Type.*;
import java.util.HashMap;
import java.util.ArrayList;

public class TypeCheckVisitor implements Visitor{
  class FunctionHandle{
    public FunctionDecl fd;
  };
  HashMap<String, FunctionHandle> ftable;
  HashMap<String, Type> vtable;
  ArrayList<SemanticError> semanticErrors;

  void setVariable(Identifier id, Type type){
    if(type.toShortString().equals("void")){
      semanticErrors.add(new SemanticError("variable cannot have void type", type.line, type.pos));
    }
    if(vtable.containsKey(id.name)){
      semanticErrors.add(new SemanticError("variable with name " + id.name + " cannot be redefined", id.line, id.pos));
    }
    vtable.put(id.name, type);
  }

  public Boolean visit(Program p){
    semanticErrors = new ArrayList<SemanticError>();
    ftable = new HashMap<String, FunctionHandle>();
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
    FunctionHandle functionHandle = new FunctionHandle();
    functionHandle.fd = fd;
    if(ftable.containsKey(fd.id.name)){
      semanticErrors.add(new SemanticError("function with name " + fd.id.name + " cannot be defined twice", fd.id.line, fd.id.pos));
    }
    ftable.put(fd.id.name, functionHandle);
    fd.params.accept(this);
    return fd.type;
  }
  public Object visit(FunctionBody fb){
    for(int i = 0; i < fb.numVars(); i++){
      fb.varAt(i).accept(this);
    }
    return null;
  }
  public Object visit(Type ct){return null;}
  public Object visit(Identifier id){return null;}
  public Object visit(Parameter param){
    setVariable(param.id, param.type);
    return null;
  }
  public Object visit(ParameterList params){
    for(int i = 0; i < params.size(); i++){
      System.out.println("test");
      params.getAt(i).accept(this);
    }
    return null;
  }
  public Object visit(VarDecl vd){
    setVariable(vd.id, vd.type);
    return null;
  }
  public Object visit(AssignStatement assignStatement){return null;}
  public Object visit(ArrayAssignStatement assignStatement){return null;}
  public Object visit(ExprStatement exprStatement){return null;}
  public Object visit(IfStatement ifStatement){return null;}
  public Object visit(WhileStatement whileStatement){return null;}
  public Object visit(PrintStatement printStatement){return null;}
  public Object visit(PrintlnStatement printlnStatement){return null;}
  public Object visit(ReturnStatement returnStatement){return null;}
  public Object visit(Block block){return null;}
  public Object visit(EqualsExpr equalsExpr){return null;}
  public Object visit(LessThanExpr lessThanExpr){return null;}
  public Object visit(AddExpr lessThanExpr){return null;}
  public Object visit(SubtractExpr lessThanExpr){return null;}
  public Object visit(MultExpr multExpr){return null;}
  public Object visit(StringLiteral stringLiteral){return null;}
  public Object visit(CharLiteral stringLiteral){return null;}
  public Object visit(IntegerLiteral stringLiteral){return null;}
  public Object visit(FloatLiteral floatLiteral){return null;}
  public Object visit(BooleanLiteral booleanLiteral){return null;}
  public Object visit(ArrayReference arrayReference){return null;}
  public Object visit(FunctionCall functionCall){return null;}
  public Object visit(ExprList exprList){return null;}
  public Object visit(ParenExpr parenExpr){return null;}
}
