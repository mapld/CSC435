package IR;

public enum IRBaseTypes{
  BOOLEAN("B"),
  CHAR("C"),
  BYTE("B"),
  SHORT("S"),
  INT("I"),
  LONG("L"),
  FLOAT("F"),
  DOUBLE("D"),
  VOID("V"),
  STRING("U");

  private final String irName;

  private IRBaseTypes(String s){
    irName = s;
  }

  public String toString(){
    return this.irName;
  }
}

