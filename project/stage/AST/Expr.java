package AST;

public abstract class Expr{
  public abstract void accept(Visitor v);
}
