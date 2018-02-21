package AST;

public class EqualsExpr extends Expr{
  public Expr left;
  public Expr right;
  public int line;
  public int pos;
  public EqualsExpr(Expr left, Expr right, int line, int pos){
    this.left = left;
    this.right = right;
    this.line = line;
    this.pos = pos;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
