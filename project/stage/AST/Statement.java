package AST;

import java.util.*;

public abstract class Statement{
  public abstract void accept (Visitor v);
}
