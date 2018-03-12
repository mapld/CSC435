package AST;

public class BooleanLiteral extends Literal{
    public boolean value;
    public BooleanLiteral(boolean b, int line, int pos){
        value = b;
        this.line = line;
        this.pos = pos;
    }
    public Object accept(Visitor v){
        return v.visit(this);
    }
    public String toString(){
      if(value){
        return "TRUE";
      }
      return "FALSE";
    }
}
