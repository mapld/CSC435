package AST;

public class ArrayAssignStatement extends Statement{
    public Identifier id;
    public Expr indexExpr;
    public Expr assignExpr;
    public ArrayAssignStatement(Identifier id, Expr indexExpr, Expr assignExpr){
        this.id = id;
        this.indexExpr = indexExpr;
        this.assignExpr = assignExpr;
    }
    public Object accept (Visitor v){
        return v.visit(this);
    }
}
