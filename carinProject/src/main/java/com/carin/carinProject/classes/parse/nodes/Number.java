package com.carin.classes.parse.nodes;

import com.carin.classes.parse.SyntaxError;
import com.carin.interfaces.Node;

import java.util.Map;

public class Number implements Node{
    int num;

    public Number(int num){
        this.num = num;
    }

    @Override
    public int evaluate(Map<String,Integer> bindings) throws SyntaxError {
        return num;
    }
}
