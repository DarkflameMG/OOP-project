package classes.parse;

import interfaces.Node;

import java.util.Map;

public class Identifier implements Node{        //parsePower
    private String name;

    public Identifier(String name)
    {
        this.name = name;
    }

    @Override
    public int evaluate(Map<String,Node> bindings) throws SyntaxError {
        if (bindings.containsKey(name))
            return bindings.get(name).evaluate(bindings);
        throw new SyntaxError("undefined variable: " + name);
    }
    
}
