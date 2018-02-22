package AST;

public class ParenExpr extends Expr{
    public Expr innerExpr;
    public ParenExpr(Expr innerExpr){
        this.innerExpr = innerExpr;
        line = innerExpr.line;
        pos = innerExpr.pos;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
