package AST;

public class SubtractExpr extends Expr{
  Expr left;
  Expr right;
  public SubtractExpr(Expr left, Expr right){
    this.left = left;
    this.right = right;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
