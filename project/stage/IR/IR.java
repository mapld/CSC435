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
      // print function decl

      // print instructions
      List<IRInstruction> instructions = functions.get(i).instructions;
      for(int j = 0; j < instructions.size(); j++){
        System.out.println(instructions.get(i).toString() + ";");
      }
    }
  }

  // create a new function, and put it on top so that any instructions added are added to this function
  public void startFunction(IRFunction function){
    currentFunction = function;
    functions.add(currentFunction);
  }

  public int getTemporary(IRType type){
    return currentFunction.getTemporary(type);
  }

  // add instruction to latest declared function
  public void addInstruction(IRInstruction instruction){
    currentFunction.addInstruction(instruction);
  }
}
