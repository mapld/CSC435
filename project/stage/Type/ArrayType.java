package Type;
import AST.*;

public class ArrayType extends Type {
  public Type baseType;
  public int arraySize;

  public ArrayType (Type type, int size) {
    baseType = type;
    arraySize = size;
  }
  public String toShortString() {
    return baseType.toShortString() + "[" + arraySize + "]";
  }
  public boolean equals (Object o) {
    if (o instanceof ArrayType){
      ArrayType other = (ArrayType)o;
      if(other.baseType.equals(this.baseType) && other.arraySize == this.arraySize){
        return true;
      }
    }
    return false;
  }

  public void accept (Visitor v) {
    v.visit(this);
  }
}
