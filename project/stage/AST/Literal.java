package AST;

public abstract class Literal extends Expr{
    public abstract Object accept(Visitor v);
}
