package AST;

import java.util.*;

public class ExprList{
    ArrayList<Expr> exprs;

    public ExprList(){
        exprs = new ArrayList<Expr>();
    }

    public int size(){
        return exprs.size();
    }

    public Expr getAt(int index){
        return exprs.get(index);
    }

    public void add(Expr expr){
        exprs.add(expr);
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}
