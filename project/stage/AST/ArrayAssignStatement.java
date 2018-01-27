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
    public void accept (Visitor v){
        v.visit(this);
    }
}
