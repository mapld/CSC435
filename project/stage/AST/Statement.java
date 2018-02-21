package AST;

import java.util.*;

public abstract class Statement extends ASTNode{
  public abstract Object accept (Visitor v);
}
