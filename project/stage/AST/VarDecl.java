package AST;

import Type.*;

public class VarDecl{
  public Type type;
  public Identifier id;
  public VarDecl(Type type, Identifier id){
    this.type = type;
    this.id = id;
  }
  public void accept(Visitor v){
    v.visit(this);
  }
}
