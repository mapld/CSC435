package AST;

public abstract class Expr extends ASTNode{
  public int line;
  public int pos;
  public abstract Object accept(Visitor v);
}
