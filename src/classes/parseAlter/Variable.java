package classes.parseAlter;

import classes.parse.SyntaxError;
import interfaces.Node;

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
