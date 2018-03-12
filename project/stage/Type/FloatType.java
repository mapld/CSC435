package Type;
import AST.*;

public class FloatType extends Type {
  public FloatType () {
  }
  public String toShortString() {
    return "float";
  }
  public boolean equals (Object o) {
    if (o instanceof FloatType)
      return true;
    else
      return false;
  }

  public Object accept (Visitor v) {
    return v.visit(this);
  }
}
