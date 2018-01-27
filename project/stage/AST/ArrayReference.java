package AST;

public class ArrayReference extends Expr{
  public Identifier id;
  public Expr expr;
  public ArrayReference(Identifier id, Expr expr){
      this.id = id;
      this.expr = expr;
  }
  public void accept(Visitor v){
      v.visit(this);
  }
}
