package AST;
import Type.*;

import java.util.*;

public class Parameter extends ASTNode{
  public Type type;
  public Identifier id;

  public Parameter(Type type, Identifier id){
    this.type = type;
    this.id = id;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
