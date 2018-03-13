package IR;

import java.util.List;

public class IRCallInstruction extends IRInstruction{
  int assignOperand = -1; // return value assigned to this temporary
  String functionName;
  List<Integer> operands;

  public IRCallInstruction(String functionName, List<Integer> operands){
    this.functionName = functionName;
    this.operands = operands;
  }

  public IRCallInstruction(String functionName, List<Integer> operands, int assignOperand){
    this.functionName = functionName;
    this.operands = operands;
    this.assignOperand = assignOperand;
  }

  public String toString(){
    String repr = "  ";
    if(assignOperand >= 0){
      repr += "T" + assignOperand + " := ";
    }
    repr += "CALL " + functionName + "(";
    for(Integer operand : operands){
      repr += "T" + operand;
    }
    repr += ")";
    return repr;
  }
}
