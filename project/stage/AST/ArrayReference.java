package AST;

public class ArrayReference extends Expr{
  public Identifier id;
  public Expr expr;
  public ArrayReference(Identifier id, Expr expr){
      this.id = id;
      this.expr = expr;
  }
  public Object accept(Visitor v){
      return v.visit(this);
  }
}
