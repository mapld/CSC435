package AST;

public class IntegerLiteral extends Literal{
    public int value;
    public IntegerLiteral(int s, int line, int pos){
        value = s;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
