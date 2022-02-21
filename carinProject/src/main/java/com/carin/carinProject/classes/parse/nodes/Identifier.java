package main.java.com.carin.carinProject.classes.parse.nodes;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;
import main.java.com.carin.carinProject.interfaces.Node;

import java.util.Map;

public class Identifier implements Node{        //parsePower
    private String name;

    public Identifier(String name)
    {
        this.name = name;
    }

    @Override
    public int evaluate(Map<String,Integer> bindings) throws SyntaxError {
        if (bindings.containsKey(name))
            return bindings.get(name);
        throw new SyntaxError("undefined variable: " + name);
    }
    
}
