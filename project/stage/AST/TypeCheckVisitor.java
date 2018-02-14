package AST;
import Semantic.*;
import Type.*;
import java.util.HashMap;

public class TypeCheckVisitor implements Visitor{
  HashMap<String, Type> ftable;
  HashMap<String, Type> vtable;

  public Type visit(Program p){
    ftable = new HashMap<String, Type>();
    for(int i = 0; i < p.size(); i++){
      Function f = p.elementAt(i);
      f.accept(this);
    }
    Type mainType = ftable.get("main");
    if(mainType == null){
      throw new SemanticException("missing main function",0,0);
    }
    if(mainType.toShortString() != "void"){
      int line = 0;
      int offset = 0;
      throw new SemanticException("main must be void", line, offset);
    }
    return null;
  }
  public Type visit(Function f){return null;}
  public Object visit(FunctionDecl fd){return null;}
  public Object visit(FunctionBody fb){return null;}
  public Object visit(Type ct){return null;}
  public Object visit(Identifier id){return null;}
  public Object visit(Parameter param){return null;}
  public Object visit(ParameterList params){return null;}
  public Object visit(VarDecl vd){return null;}
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
