package AST;

public class WhileStatement extends Statement{
  public Expr condition;
  public Block block;
  public WhileStatement(Expr condition, Block block){
    this.condition = condition;
    this.block = block;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
