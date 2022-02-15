package classes.parse;

import interfaces.Node;

public class RandomNumber implements Node{
    int num;

    public RandomNumber(int num){
        this.num = num;
    }

    @Override
    public int evaluate() throws SyntaxError {
        return num;
    }
}