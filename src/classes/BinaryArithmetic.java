package classes;

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
    public double evaluate() throws SyntaxError{
        double a = left.evaluate();
        double b = right.evaluate();

        if(opr.equals("+")) return a+b;
        if(opr.equals("-")) return a-b;
        if(opr.equals("*")) return a*b;
        if(opr.equals("/")) return a/b;
        if(opr.equals("%")) return a%b;
        if(opr.equals("^")) return Math.pow(a,b);
        // return 0;
        throw new SyntaxError("unknown oprator: "+ opr);
    }
}
