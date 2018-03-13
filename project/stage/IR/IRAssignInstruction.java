package IR;
import AST.*;

public class IRAssignInstruction extends IRInstruction{
  public enum AssignTypes{
    CONST_TO_OP,
    NEWARRAY,
    OP_TO_OP,
    OP_TO_ARRAY,
    ARRAY_TO_OP,
    UNARY_OP,
    BINARY_OP
  }

  public enum UnaryOps{
    NEGATION("-"),
    INVERSION("!"),
    CONVERT("2");

    private final String opName;

    private UnaryOps(String s){
      opName = s;
    }

    public String toString(){
      return this.opName;
    }
  }

  public enum BinaryOps{
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    REM("rem"),
    SMALLER("<"),
    SMALLER_EQUALS("<="),
    EQUALS("=="),
    NOT_EQUALS("!="),
    BIGGER_EQUALS(">="),
    BIGGER(">");

    private final String opName;

    private BinaryOps(String s){
      opName = s;
    }

    public String toString(){
      return this.opName;
    }
  }

  public AssignTypes type;
  public int leftTemp;
  public int rightTemp;
  public int indexTemp;
  public int size;
  public BinaryOps binaryOp;
  public UnaryOps unaryOp;
  public IRType opType;
  public IRType toType;
  public Literal constant;

  public String toString(){
    String repr = "  ";
    switch(type){
    case OP_TO_OP:
      repr += "T";
      repr += leftTemp;
      repr += " := ";
      repr += "T";
      repr += rightTemp;
      break;
    case CONST_TO_OP:
      repr += "T";
      repr += leftTemp;
      repr += " := ";
      repr += constant.toString();
      break;
    case OP_TO_ARRAY:
      repr += "T";
      repr += leftTemp;
      repr += "[T";
      repr += indexTemp;
      repr += "]";
      repr += " := ";
      repr += "T";
      repr += rightTemp;
      break;
    case NEWARRAY:
      repr += "T";
      repr += leftTemp;
      repr += " := NEWARRAY";
      repr += "(";
      repr += opType.toString();
      repr += ")";
      repr += size;
      break;
    }
    return repr;
  }
}
