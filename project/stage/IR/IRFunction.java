package IR;
import java.util.List;
import java.util.ArrayList;

public class IRFunction{
  public List<IRInstruction> instructions;
  public List<IRType> temporaries;

  public IRFunction(){
    instructions = new ArrayList<IRInstruction>();
  }

  public void addInstruction(IRInstruction instruction){
    instructions.add(instruction);
  }

  public int getNewTemp(IRType type){
    temporaries.add(type);
    return temporaries.size()-1;
  }
}
