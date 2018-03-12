package Type;
import AST.*;

public abstract class Type {
  public int line;
  public int pos;
  public void addPositionalInfo(int line, int pos){
    this.line = line;
    this.pos = pos;
  }
  public abstract Object accept (Visitor v);
  public abstract String toShortString();
  public abstract boolean equals (Object o);
}
