package AST;

public class BooleanLiteral extends Literal{
    public boolean value;
    public BooleanLiteral(boolean b, int line, int pos){
        value = b;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
