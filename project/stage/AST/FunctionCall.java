package AST;

public class FunctionCall extends Expr{
    public Identifier id;
    public ExprList exprList;
    public FunctionCall(Identifier id, ExprList exprList){
        this.id = id;
        this.exprList = exprList;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
