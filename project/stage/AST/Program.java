package AST;
import java.util.ArrayList;

public class Program extends ASTNode{
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
  public Object accept(Visitor v){
    return v.visit((this));
  }
}
