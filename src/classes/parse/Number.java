package classes.parse;

import interfaces.Node;

public class Number implements Node{
    int num;

    public Number(int num){
        this.num = num;
    }

    @Override
    public int evaluate() throws SyntaxError {
        return num;
    }
}
