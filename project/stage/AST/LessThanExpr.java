package AST;

public class LessThanExpr extends Expr{
  Expr left;
  Expr right;
  public LessThanExpr(Expr left, Expr right){
    this.left = left;
    this.right = right;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
