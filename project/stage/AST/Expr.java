package AST;

public abstract class Expr extends ASTNode{
  public abstract Object accept(Visitor v);
}
