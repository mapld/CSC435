package AST;
import java.util.ArrayList;

public class Program{
  public Program(){
  }
  public void addFunction(Function f){
  }
  // public Function elementAt(int index){
  // }
  // public int size(){
  //   return functionList.size();
  // }
  public void accept(Visitor v){
    v.visit((this));
  }
}
