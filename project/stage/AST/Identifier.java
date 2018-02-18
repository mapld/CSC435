package AST;

public class Identifier extends Expr{
  public String name;
  public int line;
  public int pos;

  public Identifier(String name, int line, int pos){
    this.name = name;
    this.line = line;
    this.pos = pos;
  }

  public Object accept (Visitor v) {
    return v.visit(this);
  }
}
