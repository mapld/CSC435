package IR;

public class IRReturnInstruction extends IRInstruction{
  int operand = -1;

  public IRReturnInstruction(){
    this.operand = -1;
  }

  public IRReturnInstruction(int operand){
    this.operand = operand;
  }

  public String toString(){
    String repr = "  " + "RETURN";
    if(operand >= 0){
      repr += " " + "T" + operand;
    }
    return repr;
  }
}
