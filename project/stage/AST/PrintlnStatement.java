package AST;

public class PrintlnStatement extends Statement{
  public Expr expr;
  public PrintlnStatement(Expr expr){
    this.expr = expr;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
