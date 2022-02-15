package classes.parse;

import interfaces.Node;

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
    public int evaluate() throws SyntaxError{
        int a = left.evaluate();
        int b = right.evaluate();

        if(opr.equals("+")) return a+b;
        if(opr.equals("-")) return a-b;
        if(opr.equals("*")) return a*b;
        if(opr.equals("/")) return a/b;
        if(opr.equals("%")) return a%b;
        if(opr.equals("^")) return (int) Math.pow(a,b);
        // return 0;
        throw new SyntaxError("unknown oprator: "+ opr);
    }

}
