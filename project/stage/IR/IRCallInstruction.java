package IR;

import java.util.List;
import java.io.PrintWriter;

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

  public void printJasmin(PrintWriter pw, JasminInfo ji){
    String paramTypes = "";
    IRType returnType = ji.functionTypeMap.get(functionName);
    for(Integer operand : operands){
      IRType curType = ji.curFunction.temporaries.get(operand);
      pw.println(ji.loadInstr(curType) + operand);
      paramTypes += ji.getTypeStringUpper(curType);
    }
    pw.println("invokestatic " + ji.className + "/" + functionName + "(" + paramTypes + ")"
               + ji.getTypeStringUpper(returnType));
    if(assignOperand >= 0){
      pw.println(ji.storeInstr(returnType) + assignOperand);
    }
  }

  public String toString(){
    String repr = "  ";
    if(assignOperand >= 0){
      repr += "T" + assignOperand + " := ";
    }
    repr += "CALL " + functionName + "(";
    for(Integer operand : operands){
      repr += "T" + operand + " ";
    }
    repr += ")";
    return repr;
  }
}
