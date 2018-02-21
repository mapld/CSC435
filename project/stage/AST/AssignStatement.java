package AST;

public class AssignStatement extends Statement{
  public Identifier id;
  public Expr expr;
  public AssignStatement(Identifier id, Expr expr){
    this.id = id;
    this.expr = expr;
  }
  public Object accept (Visitor v){
    return v.visit(this);
  }
}
