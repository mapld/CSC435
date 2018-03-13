package IR;
import AST.*;
import java.util.Map;
import java.util.HashMap;

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
    private static final Map<String, BinaryOps>  lookup = new HashMap<String, BinaryOps>();

    static{
      for (BinaryOps bo : BinaryOps.values()){
        lookup.put(bo.toString(), bo);
      }
    }

    private BinaryOps(String s){
      opName = s;
    }

    public String toString(){
      return this.opName;
    }

    public static BinaryOps get(String val){
      return lookup.get(val);
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
    case ARRAY_TO_OP:
      repr += "T";
      repr += leftTemp;
      repr += " := ";
      repr += "T" + rightTemp + "[";
      repr += "T" + indexTemp + "]";
      break;
    case NEWARRAY:
      repr += "T";
      repr += leftTemp;
      repr += " := NEWARRAY ";
      repr += opType.toString();
      repr += " ";
      repr += size;
      break;
    case BINARY_OP:
      repr += "T";
      repr += indexTemp;
      repr += " := T";
      repr += leftTemp + " " + opType.toString() + binaryOp.toString() + " ";
      repr += "T" + rightTemp;
      break;
    case UNARY_OP:
      if(unaryOp == UnaryOps.CONVERT){
        repr += "T" + leftTemp;
        repr += " := " + opType.toString() + "2" + toType.toString() + " ";
        repr += "T" + rightTemp;
      }
      break;
    }
    return repr;
  }
}
