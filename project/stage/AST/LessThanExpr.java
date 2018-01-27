package AST;

public class LessThanExpr extends Expr{
  public Expr left;
  public Expr right;
  public LessThanExpr(Expr left, Expr right){
    this.left = left;
    this.right = right;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
