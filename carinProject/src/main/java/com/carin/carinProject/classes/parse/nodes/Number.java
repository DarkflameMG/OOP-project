package main.java.com.carin.carinProject.classes.parse.nodes;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;
import main.java.com.carin.carinProject.interfaces.Node;

import java.util.Map;

public class Number implements Node {
    int num;

    public Number(int num){
        this.num = num;
    }

    @Override
    public int evaluate(Map<String,Integer> bindings) throws SyntaxError {
        return num;
    }
}
