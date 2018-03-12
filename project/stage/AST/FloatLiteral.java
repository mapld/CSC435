package AST;

public class FloatLiteral extends Literal{
    public float value;
    public FloatLiteral(float s, int line, int pos){
        value = s;
        this.line = line;
        this.pos = pos;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
    public String toString(){
      return "" + value;
    }
}
