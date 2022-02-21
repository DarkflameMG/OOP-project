package com.carin.carinProject.classes.parseAlter;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.interfaces.Node;

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
