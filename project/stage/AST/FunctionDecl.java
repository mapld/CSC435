package AST;
import Type.*;

public class FunctionDecl extends ASTNode{
  Type type;
  Identifier id;
  ParameterList params;
  public FunctionDecl(Type type, Identifier id, ParameterList params){
    this.type = type;
    this.id = id;
    this.params = params;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
