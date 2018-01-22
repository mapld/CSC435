package AST;

public class Function{
  public FunctionDecl functionDecl;
  public FunctionBody functionBody;

  public Function(FunctionDecl fd, FunctionBody fb){
    functionDecl = fd;
    functionBody = fb;
  }

  public void accept(Visitor v){
    v.visit(this);
  }
}
