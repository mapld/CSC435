package AST;

public class ReturnStatement extends Statement{
  public Expr expr;
  public ReturnStatement(Expr expr){
    this.expr = expr;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
