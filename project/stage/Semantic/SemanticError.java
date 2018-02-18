package Semantic;

public class SemanticError{
    String	message;
    int	line;
    int	offset;

    public SemanticError(String msg, int l, int o){
        message = msg;
        line = l;
        offset = o;
    }

    public String toString(){
        String s = "Error on line " + line + "(" + offset + "): " + message;
        return s;
    }
}
