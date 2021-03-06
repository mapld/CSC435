package AST;

public class AddExpr extends Expr{
  public Expr left;
  public Expr right;
  public AddExpr(Expr left, Expr right, int line, int pos){
    this.left = left;
    this.right = right;
    this.line = line;
    this.pos = pos;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
