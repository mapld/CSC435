package AST;

public class ExprStatement extends Statement{
    public Expr expr;
    public ExprStatement(Expr expr){
        this.expr = expr;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
