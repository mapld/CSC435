package AST;

public class ReturnStatement extends Statement{
  public Expr expr;
  public ReturnStatement(Expr expr){
    this.expr = expr;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
