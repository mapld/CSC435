package AST;

public abstract class Literal extends Expr{
    public abstract void accept(Visitor v);
}
