package IR;
import java.io.PrintWriter;

public class IRLabelInstruction extends IRInstruction{
  public int number;

  public IRLabelInstruction(int n){
    number = n;
  }

  public void printJasmin(PrintWriter pw, JasminInfo jaasminInfo){
    pw.println(toString());
  }

  public String toString(){
    return "L" + number + ":";
  }
}
