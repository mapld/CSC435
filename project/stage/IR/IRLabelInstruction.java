package IR;

public class IRLabelInstruction extends IRInstruction{
  public int number;

  public IRLabelInstruction(int n){
    number = n;
  }

  public String toString(){
    return "L" + number + ":";
  }
}
