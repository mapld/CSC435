package Type;
import AST.*;

public class CharType extends Type {
  public CharType () {
  }
  public String toShortString() {
    return "char";
  }
  public boolean equals (Object o) {
    if (o instanceof CharType)
      return true;
    else
      return false;
  }

  public Object accept (Visitor v) {
    return v.visit(this);
  }
}
