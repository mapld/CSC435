package AST;

public class IfStatement extends Statement{
  public Expr condition;
  public Block ifBlock;
  public Block elseBlock;
  public IfStatement(Expr condition, Block ifBlock, Block elseBlock){
    this.condition = condition;
    this.ifBlock = ifBlock;
    this.elseBlock = elseBlock;
  }
  public Object accept(Visitor v){
    return v.visit(this);
  }
}
