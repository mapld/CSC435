package AST;

public class MultExpr extends Expr{
  Expr left;
  Expr right;
  public MultExpr(Expr left, Expr right){
    this.left = left;
    this.right = right;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
