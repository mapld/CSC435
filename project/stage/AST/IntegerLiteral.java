package AST;

public class IntegerLiteral extends Literal{
    public int value;
    public IntegerLiteral(int s, int line, int pos){
        value = s;
        this.line = line;
        this.pos = pos;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
