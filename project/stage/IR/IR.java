package IR;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IR{
  List<IRFunction> functions;
  Map<String,IRType> functionTypeMap;
  IRFunction currentFunction;
  String name;

  public IR(String name){
    this.name = name;
    functions = new ArrayList<IRFunction>();
    functionTypeMap = new HashMap<String,IRType>();
  }

  public void printIR(String filename){
    try{
    PrintWriter pw = new PrintWriter(new FileWriter(filename));

    pw.println("PROG " + name);

    for(int i = 0; i < functions.size(); i++){
      IRFunction function = functions.get(i);
      // print function decl
      pw.println(function);

      pw.println("{");

      // print temporaries
      List<IRType> temps = function.temporaries;
      for(int j = 0; j < temps.size(); j++){
        IRType type = temps.get(j);
        pw.println("  TEMP " + j + ":" + type.toString() + ";");
      }

      // print instructions
      List<IRInstruction> instructions = function.instructions;
      for(int j = 0; j < instructions.size(); j++){
        pw.println(instructions.get(j).toString() + ";");
      }

      pw.println("}");
      pw.flush();
    }
    }
    catch(IOException e){
      System.out.println(e);
      return;
    }
  }


  public void printJasmin(String filename){

    JasminInfo jasminInfo = new JasminInfo();
    jasminInfo.labelCount = 0;
    jasminInfo.className = name;
    jasminInfo.functionTypeMap = functionTypeMap;

    try{
      PrintWriter pw = new PrintWriter(new FileWriter(filename));

      pw.println(".class public " + name);
      pw.println(".super java/lang/Object");

      for(int i = 0; i < functions.size(); i++){
        pw.println("");
        IRFunction function = functions.get(i);
        jasminInfo.curFunction = function;

        String fname = function.name;
        if(fname.equals("main")){
          fname = "__main";
        }
        String typeList = "";
        for(int j = 0; j < function.params.size(); j++){
          int tIndex = function.params.get(j);
          IRType type = function.temporaries.get(tIndex);
          typeList += jasminInfo.getTypeStringUpper(type);
        }
        pw.println(".method public static " + fname + "(" + typeList + ")" + function.returnType.toString());

        int startLabel = jasminInfo.labelCount;
        jasminInfo.labelCount += 2;

        int localCount = function.temporaries.size();
        pw.println(".limit locals " + localCount);
        for(int j = 0; j < localCount; j++){
          IRType localType = function.temporaries.get(j);
          pw.println(".var " + j + " is T" + j + " " + jasminInfo.getTypeStringUpper(localType) + " from L_" + startLabel + " to L_" + (startLabel + 1));
        }

        int stackLimit = 16;
        pw.println(".limit stack " + stackLimit);


        pw.println("L_" + startLabel + ":");


        for(int j = 0; j < function.instructions.size(); j++){
          pw.println("; " + function.instructions.get(j).toString());
          function.instructions.get(j).printJasmin(pw, jasminInfo);
        }

        pw.println("L_" + (startLabel + 1) + ":");
        pw.println(".end method");
      }


      // Extra boilerplate code
      pw.println("");
      pw.println(".method public static main([Ljava/lang/String;)V");
      pw.println(".limit locals 1");
      pw.println(".limit stack 4");
      pw.println("invokestatic " + name + "/__main()V");
      pw.println("return");
      pw.println(".end method");

      pw.println("");
      pw.println(".method public <init>()V");
      pw.println("aload_0");
      pw.println("invokenonvirtual java/lang/Object/<init>()V");
      pw.println("return");
      pw.println(".end method");


      pw.flush();
    }
    catch(IOException e){
        System.out.println(e);
        return;
    }
  }

  // create a new function, and put it on top so that any instructions added are added to this function
  public void startFunction(String name, IRType returnType){
    currentFunction = new IRFunction(name, returnType);
    functionTypeMap.put(name, currentFunction.returnType);
    functions.add(currentFunction);
  }

  // returns temporary number used for param
  public int addFunctionParam(IRType type){
    int tempNum = currentFunction.getNewTemp(type);
    currentFunction.addParam(tempNum);
    return tempNum;
  }

  public int getTemporary(IRType type){
    return currentFunction.getNewTemp(type);
  }

  public int getTemporary(IRBaseTypes baseType){
    return getTemporary(new IRType(baseType, false));
  }

  public int getArrayTemporary(IRBaseTypes baseType){
    return getTemporary(new IRType(baseType, true));
  }

  public int getLabel(){
    return currentFunction.getNewLabel();
  }

  public IRType getTemporaryType(int tempNum){
    return currentFunction.getTemporaryType(tempNum);
  }

  // add instruction to latest declared function
  public void addInstruction(IRInstruction instruction){
    currentFunction.addInstruction(instruction);
  }
}
