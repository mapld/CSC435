package AST;

import java.util.*;

public class ParameterList{
  ArrayList<Parameter> params;

  public ParameterList(){
    params = new ArrayList<Parameter>();
  }

  public int size(){
    return params.size();
  }

  public Parameter getAt(int index){
    return params.get(index);
  }

  public void add(Parameter parameter){
    params.add(parameter);
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
