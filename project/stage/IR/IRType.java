package IR;

public class IRType{
  public boolean isArray;
  public IRBaseTypes baseType;
  public IRType(IRBaseTypes baseType, boolean isArray){
    this.isArray = isArray;
    this.baseType = baseType;
  }
  public String toString(){
    String repr = "";
    if(isArray){
      repr += "A";
    }
    repr += baseType.toString();
    return repr;
  }
}
