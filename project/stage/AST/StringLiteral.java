package AST;

public class StringLiteral extends Literal{
    public String value;
    public StringLiteral(String s, int line, int pos){
        value = s.substring(1,s.length()-1);
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
