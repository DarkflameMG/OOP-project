package classes.parse.nodes;

import classes.parse.SyntaxError;
import interfaces.Node;

import java.util.Map;

public class BinaryArithmetic implements Node{
    Node left;
    Node right;
    String opr;

    public BinaryArithmetic(Node left, Node right, String opr){
        this.left = left;
        this.right = right;
        this.opr = opr;
    }
    
    @Override
    public int evaluate(Map<String,Integer> bindings) throws SyntaxError {
        int a = left.evaluate(bindings);
        int b = right.evaluate(bindings);

        if(opr.equals("+")) return a+b;
        if(opr.equals("-")) return a-b;
        if(opr.equals("*")) return a*b;
        if(opr.equals("/")) {
            if(b == 0){
                throw new SyntaxError("cannot divided by zero");
            }
            return a/b;
        }if(opr.equals("%")) {
            if(b == 0){
                throw new SyntaxError("cannot modurate by zero");
            }
            return a%b;
        }if(opr.equals("^")) return (int) Math.pow(a,b);
        // return 0;
        throw new SyntaxError("unknown oprator: "+ opr);
    }

    public void prettyPrint(StringBuilder s) {              //for test
        s.append("(");
        ((BinaryArithmetic) left).prettyPrint(s);
        s.append(opr);
        ((BinaryArithmetic) right).prettyPrint(s);
        s.append(")");
    }

}
