package AST;

public class PrintStatement extends Statement{
  public Expr expr;
  public PrintStatement(Expr expr){
    this.expr = expr;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
