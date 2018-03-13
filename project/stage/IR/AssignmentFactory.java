package IR;
import AST.*;

public class AssignmentFactory{
  public static IRAssignInstruction createConstantAssignment(int temporary, Literal constant){
    IRAssignInstruction inst = new IRAssignInstruction();
    inst.type = IRAssignInstruction.AssignTypes.CONST_TO_OP;
    inst.leftTemp = temporary;
    inst.constant = constant;
    return inst;
  }

  public static IRAssignInstruction createOperandAssignment(int leftTemp, int rightTemp){
    IRAssignInstruction inst = new IRAssignInstruction();
    inst.type = IRAssignInstruction.AssignTypes.OP_TO_OP;
    inst.leftTemp = leftTemp;
    inst.rightTemp = rightTemp;
    return inst;
  }

  public static IRAssignInstruction createArrayAssignment(int leftTemp, int indexTemp, int rightTemp){
    IRAssignInstruction inst = new IRAssignInstruction();
    inst.type = IRAssignInstruction.AssignTypes.OP_TO_ARRAY;
    inst.leftTemp = leftTemp;
    inst.indexTemp = indexTemp;
    inst.rightTemp = rightTemp;
    return inst;
  }

  public static IRAssignInstruction createAssignmentFromArray(int leftTemp, int rightTemp, int indexTemp){
    IRAssignInstruction inst = new IRAssignInstruction();
    inst.type = IRAssignInstruction.AssignTypes.ARRAY_TO_OP;
    inst.leftTemp = leftTemp;
    inst.rightTemp = rightTemp;
    inst.indexTemp = indexTemp;
    return inst;
  }

  public static IRAssignInstruction createNewArrayAssignment(int leftTemp, IRType type, int size){
    IRAssignInstruction inst = new IRAssignInstruction();
    inst.type = IRAssignInstruction.AssignTypes.NEWARRAY;
    inst.leftTemp = leftTemp;
    inst.opType = type;
    inst.size = size;
    return inst;
  }

  public static IRAssignInstruction createBinaryOp(String operator, IRType operatorType, int assignTemp, int leftTemp, int rightTemp){
    IRAssignInstruction inst = new IRAssignInstruction();
    inst.type = IRAssignInstruction.AssignTypes.BINARY_OP;
    inst.leftTemp = leftTemp;
    inst.rightTemp = rightTemp;
    inst.indexTemp = assignTemp;
    inst.opType = operatorType;
    inst.binaryOp = IRAssignInstruction.BinaryOps.get(operator);
    return inst;
  }

  public static IRAssignInstruction createConversion(IRType fromType, IRType toType, int fromTemp, int toTemp){
    IRAssignInstruction inst = new IRAssignInstruction();
    inst.type = IRAssignInstruction.AssignTypes.UNARY_OP;
    inst.unaryOp = IRAssignInstruction.UnaryOps.CONVERT;
    inst.rightTemp = fromTemp;
    inst.leftTemp = toTemp;
    inst.opType = fromType;
    inst.toType = toType;
    return inst;
  }
}
