package AST;

public class PrintStatement extends Statement{
  public Expr expr;
  public PrintStatement(Expr expr){
    this.expr = expr;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
