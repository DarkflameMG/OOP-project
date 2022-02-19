package classes.parse.nodes;

import classes.parse.SyntaxError;
import interfaces.Node;

import java.util.Map;

public class Number implements Node{
    int num;

    public Number(int num){
        this.num = num;
    }

    @Override
    public int evaluate(Map<String,Node> bindings) throws SyntaxError {
        return num;
    }
}
