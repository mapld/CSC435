package IR;
import java.io.PrintWriter;

public abstract class IRInstruction{
  public abstract String toString();
  public abstract void printJasmin(PrintWriter pw, JasminInfo jasminInfo);
}
