package AST;

public abstract class Expr extends ASTNode{
  public abstract void accept(Visitor v);
}
