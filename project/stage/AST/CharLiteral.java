package AST;

public class CharLiteral extends Literal{
    public char value;
    public CharLiteral(String s, int line, int pos){
        value = s.charAt(1);
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
