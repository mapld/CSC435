package AST;

import java.util.*;

public abstract class Statement extends ASTNode{
  public abstract void accept (Visitor v);
}
