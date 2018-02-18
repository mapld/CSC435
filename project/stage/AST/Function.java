package AST;

public class Function extends ASTNode{
  public FunctionDecl functionDecl;
  public FunctionBody functionBody;

  public Function(FunctionDecl fd, FunctionBody fb){
    functionDecl = fd;
    functionBody = fb;
  }

  public Object accept(Visitor v){
    return v.visit(this);
  }
}
