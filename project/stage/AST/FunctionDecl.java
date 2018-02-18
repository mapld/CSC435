package AST;
import Type.*;

public class FunctionDecl extends ASTNode{
  public Type type;
  public Identifier id;
  public ParameterList params;

  public FunctionDecl(Type type, Identifier id, ParameterList params){
    this.type = type;
    this.id = id;
    this.params = params;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
