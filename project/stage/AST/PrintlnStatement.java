package AST;

public class PrintlnStatement extends Statement{
  public Expr expr;
  public PrintlnStatement(Expr expr){
    this.expr = expr;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
