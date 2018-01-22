package AST;
import Type.*;

public class TypeFactory{
  public static Type getType(String typeString, int line, int pos){
    switch(typeString){
      case "int":
        return new IntegerType();
      case "boolean":
        return new BooleanType();
      case "float":
        return new FloatType();
      case "char":
        return new CharType();
      case "string":
        return new StringType();
      case "void":
        return new VoidType();
      default:
        System.out.println("Error: invalid type at line " + line + ", pos " + pos);
        return null;
    }
  }
  public static ArrayType getArrayType(String typeString, int size, int line, int pos){
    Type baseType = getType(typeString, line, pos);
    return new ArrayType(baseType, size);
  }
}
