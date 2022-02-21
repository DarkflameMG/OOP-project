package main.java.com.carin.carinProject.classes.parse;

import main.java.com.carin.carinProject.interfaces.Node;

import java.util.Map;

public class RandomNumber implements Node {
    int num;

    public RandomNumber(int num){
        this.num = num;
    }

    @Override
    public int evaluate(Map<String,Integer> bindings) throws SyntaxError {
        return num;
    }
}