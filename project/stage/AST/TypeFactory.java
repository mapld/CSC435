package AST;
import Type.*;

public class TypeFactory{
  public static Type getType(String typeString, int line, int pos){
    Type type;
    switch(typeString){
      case "int":
        type = new IntegerType();
        break;
      case "boolean":
        type = new BooleanType();
        break;
      case "float":
        type = new FloatType();
        break;
      case "char":
        type = new CharType();
        break;
      case "string":
        type = new StringType();
        break;
      case "void":
        type = new VoidType();
        break;
      default:
        System.out.println("Error: invalid type at line " + line + ", pos " + pos);
        return null;
    }
    type.addPositionalInfo(line, pos);
    return type;
  }
  public static ArrayType getArrayType(String typeString, int size, int line, int pos){
    Type baseType = getType(typeString, line, pos);
    return new ArrayType(baseType, size);
  }
}
