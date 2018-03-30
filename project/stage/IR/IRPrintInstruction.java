package IR;
import java.io.PrintWriter;

public class IRPrintInstruction extends IRInstruction{
  boolean newLine;
  IRBaseTypes type;
  int operand;

  public void printJasmin(PrintWriter pw, JasminInfo ji){
    pw.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
    pw.println(ji.loadInstr(new IRType(type,false)) + operand);
    if(newLine){
      pw.println("invokevirtual java/io/PrintStream/println(" + ji.getTypeStringUpper(new IRType(type, false)) + ")V");
    }
    else{
      pw.println("invokevirtual java/io/PrintStream/print(" + ji.getTypeStringUpper(new IRType(type, false)) + ")V");
    }
  }

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
