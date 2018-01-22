package AST;
import Type.*;

public class PrettyPrintVisitor implements Visitor{
  StringBuilder builder = new StringBuilder();
  int indentation = 0;

  void indentLine(){
    builder.append("\n");
    for(int i = 0; i < indentation; i++){
      builder.append(" ");
    }
  }

  public PrettyPrintVisitor(){
  }
  public Object visit(Program p){
    for(int i = 0; i < p.size(); i++){
      Function f = p.elementAt(i);
      f.accept(this);
    }
    System.out.println(builder.toString());
    return null;
  }
  public Object visit(Function f){
    indentLine();
    f.functionDecl.accept(this);
    builder.append("{");
    indentation += 2;
    f.functionBody.accept(this);
    indentation -= 2;
    builder.append("\n}");
    return null;
  }
  public Object visit(FunctionDecl fd){
    indentLine();
    fd.type.accept(this);
    builder.append(" ");
    fd.id.accept(this);
    builder.append("(");
    fd.params.accept(this);
    (builder).append(")");
    return null;
  }
  public Object visit(FunctionBody fb){
    for(int i = 0; i < fb.numVars(); i++){
      fb.varAt(i).accept(this);
    }
    return null;
  }
  public Object visit(Type type){
    builder.append(type.toShortString());
    return null;
  }
  public Object visit(Identifier id){
    builder.append(id.name);
    return null;
  }
  public Object visit(Parameter param){
    param.type.accept(this);
    builder.append(" ");
    param.id.accept(this);
    return null;
  }
  public Object visit(ParameterList params){
    for(int i = 0; i < params.size(); i++){
      params.getAt(i).accept(this);
      if(i < params.size()-1){
        builder.append(", ");
      }
    }
    return null;
  }
  public Object visit(VarDecl vd){
    indentLine();
    vd.type.accept(this);
    builder.append(" ");
    vd.id.accept(this);
    builder.append(";");
    return null;
  }
}
