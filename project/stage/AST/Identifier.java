package AST;

public class Identifier{
  public String name;
  int line;
  int pos;
  public Identifier(String name, int line, int pos){
    this.name = name;
    this.line = line;
    this.pos = pos;
  }

  public void accept (Visitor v) {
    v.visit(this);
  }
}
