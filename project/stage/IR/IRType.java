package IR;

public class IRType{
  public boolean isArray;
  public IRBaseTypes baseType;
  public IRType(IRBaseTypes baseType, boolean isArray){
    this.isArray = isArray;
    this.baseType = baseType;
  }
}
