package IR;
import java.io.PrintWriter;

public class IRReturnInstruction extends IRInstruction{
  int operand = -1;

  public IRReturnInstruction(){
    this.operand = -1;
  }

  public IRReturnInstruction(int operand){
    this.operand = operand;
  }

  public void printJasmin(PrintWriter pw, JasminInfo ji){
    // TODO: returning things
    if(operand >= 0){
       pw.println(ji.loadInstr(ji.curFunction.temporaries.get(operand)) + operand); 
    }
    pw.println("return");
  }

  public String toString(){
    String repr = "  " + "RETURN";
    if(operand >= 0){
      repr += " " + "T" + operand;
    }
    return repr;
  }
}
