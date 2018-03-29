package IR;
import java.util.Map;
import java.util.HashMap;

public class JasminInfo{
  int labelCount;
  IRFunction curFunction;
  String className;
  Map<String,IRType> functionTypeMap;

  static String getArrayType(IRType type){
      if(type.baseType == IRBaseTypes.INT){
          return "int";
      }
      return "";
  }

  static String getTypeStringUpper(IRType type){
   String s = "";
   if(type.isArray){
       s += "[";
   }
   if(type.baseType == IRBaseTypes.STRING){
       s += "Ljava/lang/String;";
   }
   else{
       s += type.baseType.toString();
   }
   return s;
  }

  static String getTypeString(IRType type){
   return type.toString().toLowerCase();
  }

  static String loadInstr(IRType type){
    return getTypeString(type) + "load ";
  }

  static String storeInstr(IRType type){
    return getTypeString(type) + "store ";
  }

  static String subInstr(IRType type){
    return getTypeString(type) + "sub";
  }

  static String xorInstr(IRType type){
    return getTypeString(type) + "xor";
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
