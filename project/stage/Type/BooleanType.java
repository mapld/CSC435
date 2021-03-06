package Type;
import AST.*;

public class BooleanType extends Type {
  public BooleanType () {
  }
  public String toShortString() {
    return "boolean";
  }
  public boolean equals (Object o) {
    if (o instanceof BooleanType)
      return true;
    else
      return false;
  }

  public Object accept (Visitor v) {
    return v.visit(this);
  }
}
