package AST;
import Type.*;

public interface Visitor{
  Object visit(Program p);
  Object visit(Function f);
  Object visit(FunctionDecl fd);
  Object visit(FunctionBody fb);
  Object visit(Type ct);
  Object visit(Identifier id);
  Object visit(Parameter param);
  Object visit(ParameterList params);
  Object visit(VarDecl vd);
}
