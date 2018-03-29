package IR;
import java.io.PrintWriter;

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

  public void printJasmin(PrintWriter pw, JasminInfo jaasminInfo){
    if(operand != null){
      pw.println("iload " + operand);
      pw.println("ifne L" + number);
    }
    else{
      pw.println("goto L" + number);
    }
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
