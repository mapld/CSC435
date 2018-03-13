package IR;

public class IRJumpInstruction extends IRInstruction{
  Integer operand;
  int number;

  public IRJumpInstruction(int number, int operand){
    this.number = number;
    this.operand = operand;
  }

  public IRJumpInstruction(int number){
    this.operand = null;
    this.number = number;
  }

  public String toString(){
    String repr = "  ";
    if(operand != null){
      repr += "IF T" + operand + " ";
    }
    repr += "GOTO L" + number;
    return repr;
  }
}
