package AST;

public class StringLiteral extends Literal{
    public String value;
    public StringLiteral(String s, int line, int pos){
        value = s.substring(1,s.length()-1);
        this.line = line;
        this.pos = pos;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
    public String toString(){
      return "\"" + value + "\"";
    }
}
