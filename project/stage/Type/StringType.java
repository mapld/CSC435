package Type;
import AST.*;

public class StringType extends Type {
  public StringType () {
  }
  public String toShortString() {
    return "string";
  }
  public boolean equals (Object o) {
    if (o instanceof StringType)
      return true;
    else
      return false;
  }

  public Object accept (Visitor v) {
    return v.visit(this);
  }
}
