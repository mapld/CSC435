package IR;
import Type.*;

public class IRTools{
  public static IRType typeToIRType(Type type){
    if(type instanceof IntegerType){
      return new IRType(IRBaseTypes.INT, false);
    }
    if(type instanceof BooleanType){
      return new IRType(IRBaseTypes.BOOLEAN, false);
    }
    if(type instanceof FloatType){
      return new IRType(IRBaseTypes.FLOAT, false);
    }
    if(type instanceof VoidType){
      return new IRType(IRBaseTypes.VOID, false);
    }
    if(type instanceof StringType){
      return new IRType(IRBaseTypes.STRING, false);
    }
    if(type instanceof CharType){
      return new IRType(IRBaseTypes.CHAR, false);
    }
    if(type instanceof ArrayType){
      ArrayType at = (ArrayType)type;
      return new IRType(typeToIRType(at.baseType).baseType, true);
    }

    return null;
  }
}
