package Type;
import AST.*;

public class IntegerType extends Type {
  public IntegerType () {
  }
  public String toShortString() {
    return "int";
  }
  public boolean equals (Object o) {
    if (o instanceof IntegerType)
      return true;
    else
      return false;
  }

  public void accept (Visitor v) {
    v.visit(this);
  }
}
