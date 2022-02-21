package com.carin.classes.parseAlter;

import com.carin.classes.parse.SyntaxError;
import com.carin.interfaces.Node;

import java.util.Map;

public class Variable implements Node {
    private String name;

    public Variable(String name)
    {
        this.name = name;
    }

    @Override
    public int evaluate(Map<String,Integer> bindings)throws SyntaxError
    {
        if (bindings.containsKey(name))
            return bindings.get(name);
        throw new SyntaxError("undefined variable: " + name);
    }
}
