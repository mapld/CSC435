package IR;
import java.util.List;
import java.util.ArrayList;

public class IR{
  List<IRFunction> functions;
  IRFunction currentFunction;

  public IR(){
    functions = new ArrayList<IRFunction>();
  }

  public void printIR(){
    for(int i = 0; i < functions.size(); i++){
      IRFunction function = functions.get(i);
      // print function decl
      System.out.println(function);

      System.out.println("{");

      // print temporaries
      List<IRType> temps = function.temporaries;
      for(int j = 0; j < temps.size(); j++){
        IRType type = temps.get(j);
        System.out.println("  TEMP " + j + ":" + type.toString() + ";");
      }

      // print instructions
      List<IRInstruction> instructions = function.instructions;
      for(int j = 0; j < instructions.size(); j++){
        System.out.println(instructions.get(j).toString() + ";");
      }

      System.out.println("}");
    }
  }

  // create a new function, and put it on top so that any instructions added are added to this function
  public void startFunction(String name, IRType returnType){
    currentFunction = new IRFunction(name, returnType);
    functions.add(currentFunction);
  }

  // returns temporary number used for param
  public int addFunctionParam(IRType type){
    int tempNum = currentFunction.getNewTemp(type);
    currentFunction.addParam(tempNum);
    return tempNum;
  }

  public int getTemporary(IRType type){
    return currentFunction.getNewTemp(type);
  }

  // add instruction to latest declared function
  public void addInstruction(IRInstruction instruction){
    currentFunction.addInstruction(instruction);
  }
}
