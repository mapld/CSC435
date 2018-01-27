package AST;
import Type.*;

public class PrettyPrintVisitor implements Visitor{
  StringBuilder builder = new StringBuilder();
  int indentLevel = 4;
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
    indentLine();
    builder.append("{");
    indentation += indentLevel;
    f.functionBody.accept(this);
    indentation -= indentLevel;
    builder.append("\n}");
    return null;
  }
  public Object visit(FunctionDecl fd){
    indentLine();
    fd.type.accept(this);
    builder.append(" ");
    fd.id.accept(this);
    builder.append(" (");
    fd.params.accept(this);
    (builder).append(")");
    return null;
  }
  public Object visit(FunctionBody fb){
    for(int i = 0; i < fb.numVars(); i++){
      fb.varAt(i).accept(this);
    }
    builder.append("\n");
    for(int i = 0; i < fb.numStatements(); i++){
      fb.statementAt(i).accept(this);
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
  public Object visit(VarDecl varDecl){
    indentLine();
    varDecl.type.accept(this);
    builder.append(" ");
    varDecl.id.accept(this);
    builder.append(";");
    return null;
  }
  public Object visit(AssignStatement assignStatement){
    indentLine();
    assignStatement.id.accept(this);
    builder.append("=");
    assignStatement.expr.accept(this);
    builder.append(";");
    return null;
  }
  public Object visit(ArrayAssignStatement assignStatement){
    indentLine();
    assignStatement.id.accept(this);
    builder.append("[");
    assignStatement.indexExpr.accept(this);
    builder.append("] = ");
    assignStatement.assignExpr.accept(this);
    builder.append(";");
    return null;
  }
  public Object visit(ExprStatement exprStatement){
    indentLine();
    exprStatement.expr.accept(this);
    builder.append(";");
    return null;
  }
  public Object visit(IfStatement ifStatement){
    indentLine();
    builder.append("if (");
    ifStatement.condition.accept(this);
    builder.append(")");
    ifStatement.ifBlock.accept(this);
    if(ifStatement.elseBlock != null){
        indentLine();
        builder.append("else");
        ifStatement.elseBlock.accept(this);
    }
    return null;
  }
  public Object visit(WhileStatement whileStatement){
    indentLine();
    builder.append("while (");
    whileStatement.condition.accept(this);
    builder.append(")");
    whileStatement.block.accept(this);
    return null;
  }
  public Object visit(PrintStatement printStatement){
    indentLine();
    builder.append("print ");
    printStatement.expr.accept(this);
    builder.append(";");
    return null;
  }
  public Object visit(PrintlnStatement printlnStatement){
    indentLine();
    builder.append("println ");
    printlnStatement.expr.accept(this);
    builder.append(";");
    return null;
  }
  public Object visit(ReturnStatement returnStatement){
    indentLine();
    if(returnStatement.expr != null){
      builder.append("return ");
      returnStatement.expr.accept(this);
      builder.append(";");
    }
    else{
      builder.append("return;");
    }
    return null;
  }
  public Object visit(Block block){
    indentLine();
    builder.append("{");
    indentation += indentLevel;
    for(int i = 0; i < block.numStatements(); i++){
      block.statementAt(i).accept(this);
    }
    indentation -= indentLevel;
    indentLine();
    builder.append("}");
    return null;
  }
  public Object visit(EqualsExpr equalsExpr){
    equalsExpr.left.accept(this);
    builder.append("==");
    equalsExpr.right.accept(this);
    return null;
  }
  public Object visit(LessThanExpr lessThanExpr){
    lessThanExpr.left.accept(this);
    builder.append("<");
    lessThanExpr.right.accept(this);
    return null;
  }
  public Object visit(AddExpr addExpr){
    addExpr.left.accept(this);
    builder.append("+");
    addExpr.right.accept(this);
    return null;
  }
  public Object visit(SubtractExpr subtractExpr){
    subtractExpr.left.accept(this);
    builder.append("-");
    subtractExpr.right.accept(this);
    return null;
  }
  public Object visit(MultExpr multExpr){
    multExpr.left.accept(this);
    builder.append("*");
    multExpr.right.accept(this);
    return null;
  }
  public Object visit(StringLiteral stringLiteral){
    builder.append("\"");
    builder.append(stringLiteral.value);
    builder.append("\"");
    return null;
  }
  public Object visit(CharLiteral charLiteral){
    builder.append("\'");
    builder.append(charLiteral.value);
    builder.append("\'");
    return null;
  }
  public Object visit(IntegerLiteral integerLiteral){
    builder.append(integerLiteral.value);
    return null;
  }
  public Object visit(FloatLiteral floatLiteral){
      builder.append(floatLiteral.value);
      return null;
  }
  public Object visit(BooleanLiteral booleanLiteral){
      builder.append(booleanLiteral.value);
      return null;
  }
  public Object visit(ArrayReference arrayRef){
    arrayRef.id.accept(this);
    builder.append("[");
    arrayRef.expr.accept(this);
    builder.append("]");
    return null;
  }
  public Object visit(FunctionCall functionCall){
    functionCall.id.accept(this);
    builder.append("(");
    functionCall.exprList.accept(this);
    builder.append(")");
    return null;
  }
  public Object visit(ExprList exprList){
    for(int i = 0; i < exprList.size(); i++){
        exprList.getAt(i).accept(this);
        if(i != exprList.size()-1){
            builder.append(",");
        }
    }
    return null;
  }

  public Object visit(ParenExpr parenExpr){
    builder.append("(");
    parenExpr.innerExpr.accept(this);
    builder.append(")");
    return null;
  }
}

