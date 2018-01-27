package AST;

public class ParenExpr extends Expr{
    public Expr innerExpr;
    public ParenExpr(Expr innerExpr){
        this.innerExpr = innerExpr;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
