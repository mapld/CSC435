package AST;

public class FloatLiteral extends Literal{
    public float value;
    public FloatLiteral(float s, int line, int pos){
        value = s;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
