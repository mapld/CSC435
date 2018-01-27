package AST;

public class ExprStatement extends Statement{
    public Expr expr;
    public ExprStatement(Expr expr){
        this.expr = expr;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
