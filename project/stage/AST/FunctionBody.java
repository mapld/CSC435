package AST;

import java.util.*;

public class FunctionBody{
  ArrayList<VarDecl> vars;
  ArrayList<Statement> statements;

  public FunctionBody(){
    vars = new ArrayList<VarDecl>();
    statements = new ArrayList<Statement>();
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
  public void addStatement(Statement statement){
    statements.add(statement);
  }
  public Statement statementAt(int index){
    return statements.get(index);
  }
  public int numStatements(){
    return statements.size();
  }
}
