package AST;

import java.util.*;

public class Block extends ASTNode{
  ArrayList<Statement> statements;
  public Block(){
    statements = new ArrayList<Statement>();
  }
  public void accept(Visitor v){
    v.visit(this);
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
