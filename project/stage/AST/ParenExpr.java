package AST;

public class ParenExpr extends Expr{
    public Expr innerExpr;
    public ParenExpr(Expr innerExpr){
        this.innerExpr = innerExpr;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
