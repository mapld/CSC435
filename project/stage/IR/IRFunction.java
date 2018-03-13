package IR;
import java.util.List;
import java.util.ArrayList;

public class IRFunction{
  public String name;
  public List<IRInstruction> instructions;
  public List<IRType> temporaries;

  public IRType returnType;
  public List<Integer> params; // indicies for temporaries

  int labelCount = 0;

  public IRFunction(String name, IRType returnType){
    this.name = name;
    this.returnType = returnType;
    instructions = new ArrayList<IRInstruction>();
    temporaries = new ArrayList<IRType>();
    params = new ArrayList<Integer>();
  }

  public void addParam(int temporaryIndex){
    params.add(temporaryIndex);
  }

  public IRType getTemporaryType(int tempNum){
    return temporaries.get(tempNum);
  }

  public void addInstruction(IRInstruction instruction){
    instructions.add(instruction);
  }

  public int getNewTemp(IRType type){
    temporaries.add(type);
    return temporaries.size()-1;
  }

  public int getNewLabel(){
    return ++labelCount;
  }

  public String toString(){
    String repr = "FUNC ";
    repr += name + " ";
    repr += "(";
    for(int i = 0; i < params.size(); i++){
      int tIndex = params.get(i);
      IRType type = temporaries.get(tIndex);
      repr += type.toString();
    }
    repr += ")";
    repr += returnType.toString();
    return repr;
  }
}
