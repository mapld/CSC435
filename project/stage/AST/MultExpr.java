package AST;

public class MultExpr extends Expr{
  Expr left;
  Expr right;
  public int line;
  public int pos;
  public MultExpr(Expr left, Expr right, int line, int pos){
    this.left = left;
    this.right = right;
    this.line = line;
    this.pos = pos;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
