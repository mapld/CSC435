package AST;

public class CharLiteral extends Literal{
    public char value;
    public CharLiteral(String s, int line, int pos){
        value = s.charAt(1);
        this.line = line;
        this.pos = pos;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
    public String toString(){
      return "\'" + value + "\'";
    }
}
