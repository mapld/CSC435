package AST;

public class AddExpr extends Expr{
  Expr left;
  Expr right;
  public AddExpr(Expr left, Expr right){
    this.left = left;
    this.right = right;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
