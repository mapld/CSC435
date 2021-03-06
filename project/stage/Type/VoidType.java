package Type;
import AST.*;

public class VoidType extends Type {
  public VoidType () {
  }
  public String toShortString() {
    return "void";
  }
  public boolean equals (Object o) {
    if (o instanceof VoidType)
      return true;
    else
      return false;
  }

  public Object accept (Visitor v) {
    return v.visit(this);
  }
}
