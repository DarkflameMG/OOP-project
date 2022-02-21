package com.carin.classes.parse.nodes;

import com.carin.classes.parse.SyntaxError;
import com.carin.interfaces.Node;

import java.util.Map;

public class NodeDirection implements Node {
    private String direction;

    public NodeDirection(String direction)
    {
        this.direction = direction;
    }

    @Override
    public int evaluate(Map<String, Integer> bindings) throws SyntaxError {
        if(direction.equals("up"))
            return 1;
        else if(direction.equals("upright"))
            return 2;
        else if(direction.equals("right"))
            return 3;
        else if(direction.equals("downright"))
            return 4;
        else if(direction.equals("down"))
            return 5;
        else if(direction.equals("downleft"))
            return 6;
        else if(direction.equals("left"))
            return 7;
        else if(direction.equals("upleft"))
            return 8;
        return 0;
    }
}
