package IR;
import Type.*;

public class IRTools{
  public static IRType typeToIRType(Type type){
    if(type instanceof IntegerType){
      return new IRType(IRBaseTypes.INT, false);
    }
    return null;
  }
}
