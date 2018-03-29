package IR;
import java.util.Map;
import java.util.HashMap;

public class JasminInfo{
  int labelCount;
  IRFunction curFunction;
  String className;
  Map<String,IRType> functionTypeMap;

  static String loadInstr(IRType type){
    return type.toString().toLowerCase() + "load ";
  }

  static String storeInstr(IRType type){
    return type.toString().toLowerCase() + "store ";
  }

  static String subInstr(IRType type){
    return type.toString().toLowerCase() + "sub";
  }

  static String xorInstr(IRType type){
    return type.toString().toLowerCase() + "xor";
  }

  static String jLabel(int labelNum){
    return "L_" + labelNum;
  }

  static String labelInstr(int labelNum){
    return jLabel(labelNum) + ":";
  }

  static String loadConstInstr(int n){
    return "ldc " + n;
  }

  static String loadConstInstr(String c){
    return "ldc " + c;
  }

  int getLabel(){
    labelCount++;
    return labelCount - 1;
  }
}
