package IR;

public class IRPrintInstruction extends IRInstruction{
  boolean newLine;
  IRBaseTypes type;
  int operand;

  public IRPrintInstruction(boolean newLine, IRBaseTypes type, int operand){
    this.newLine = newLine;
    this.type = type;
    this.operand = operand;
  }

  public String toString(){
    String repr = "  PRINT";
    if(newLine){
      repr += "LN";
    }
    repr += type.toString();
    repr += " T" + operand;
    return repr;
  }
}
