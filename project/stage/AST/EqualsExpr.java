package AST;

public class EqualsExpr extends Expr{
  public Expr left;
  public Expr right;
  public EqualsExpr(Expr left, Expr right){
    this.left = left;
    this.right = right;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
