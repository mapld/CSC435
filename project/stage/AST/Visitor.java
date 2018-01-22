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
  public Object visit(EqualsExpr equalsExpr);
  public Object visit(LessThanExpr lessThanExpr);
  public Object visit(AddExpr lessThanExpr);
  public Object visit(SubtractExpr lessThanExpr);
  public Object visit(MultExpr multExpr);
}
