package com.carin.carinProject.classes.parse.nodes;

import com.carin.carinProject.classes.parse.RandomNumber;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.interfaces.Node;

import java.util.Map;

public class Identifier implements Node{        //parsePower
    private String name;

    public Identifier(String name)
    {
        this.name = name;
    }

    @Override
    public int evaluate(Map<String,Integer> bindings) throws SyntaxError {
        if(name.equals("random"))
            return RandomNumber.getInstance().RandNum();
        if (bindings.containsKey(name))
            return bindings.get(name);
        throw new SyntaxError("undefined variable: " + name);
    }
    
}
