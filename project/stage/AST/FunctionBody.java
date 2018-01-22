package AST;

import java.util.*;

public class FunctionBody{
  ArrayList<VarDecl> vars;
  ArrayList<Statement> statements;

  public FunctionBody(){
    vars = new ArrayList<VarDecl>();
  }
  public void accept(Visitor v){
    v.visit(this);
  }
  public void addVarDecl(VarDecl vd){
    vars.add(vd);
  }
  public VarDecl varAt(int index){
    return vars.get(index);
  }
  public int numVars(){
    return vars.size();
  }
}
