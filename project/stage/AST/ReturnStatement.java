package AST;

public class ReturnStatement extends Statement{
  public Expr expr;
  public int line;
  public int pos;
  public ReturnStatement(Expr expr, int line, int pos){
    this.expr = expr;
    this.line = line;
    this.pos = pos;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
