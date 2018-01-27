package AST;
import Type.*;

public interface Visitor{
  public Object visit(Program p);
  public Object visit(Function f);
  public Object visit(FunctionDecl fd);
  public Object visit(FunctionBody fb);
  public Object visit(Type ct);
  public Object visit(Identifier id);
  public Object visit(Parameter param);
  public Object visit(ParameterList params);
  public Object visit(VarDecl vd);
  public Object visit(AssignStatement assignStatement);
  public Object visit(ArrayAssignStatement assignStatement);
  public Object visit(ExprStatement exprStatement);
  public Object visit(IfStatement ifStatement);
  public Object visit(WhileStatement whileStatement);
  public Object visit(PrintStatement printStatement);
  public Object visit(PrintlnStatement printlnStatement);
  public Object visit(ReturnStatement returnStatement);
  public Object visit(Block block);
  public Object visit(EqualsExpr equalsExpr);
  public Object visit(LessThanExpr lessThanExpr);
  public Object visit(AddExpr lessThanExpr);
  public Object visit(SubtractExpr lessThanExpr);
  public Object visit(MultExpr multExpr);
  public Object visit(StringLiteral stringLiteral);
  public Object visit(CharLiteral stringLiteral);
  public Object visit(IntegerLiteral stringLiteral);
  public Object visit(FloatLiteral floatLiteral);
  public Object visit(BooleanLiteral booleanLiteral);
  public Object visit(ArrayReference arrayReference);
  public Object visit(FunctionCall functionCall);
  public Object visit(ExprList exprList);
  public Object visit(ParenExpr parenExpr);
}
