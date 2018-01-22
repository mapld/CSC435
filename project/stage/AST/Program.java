package AST;
import java.util.ArrayList;

public class Program{
  ArrayList<Function> functions;

  public Program(){
    functions = new ArrayList<Function>();
  }
  public void addFunction(Function f){
    functions.add(f);
  }
  public Function elementAt(int index){
    return functions.get(index);
  }
  public int size(){
    return functions.size();
  }
  public void accept(Visitor v){
    v.visit((this));
  }
}
