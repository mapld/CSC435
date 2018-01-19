package AST;

public class PrettyPrintVisitor implements Visitor{
  StringBuilder builder = new StringBuilder();

  public PrettyPrintVisitor(){
  }
  public Object visit(Program p){
    builder.append("program\n");
    System.out.println(builder.toString());
    return null;
  }
}
