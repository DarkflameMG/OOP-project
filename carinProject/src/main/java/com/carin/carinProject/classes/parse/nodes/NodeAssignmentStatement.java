package com.carin.classes.parse.nodes;

import java.util.Map;

import com.carin.interfaces.Execute;
import com.carin.interfaces.Node;

public class NodeAssignmentStatement implements Execute{

    Map<String, Integer> bindings;
    String identifier;
    Node expr;

    public NodeAssignmentStatement(Map<String, Integer> bindings, String identifier, Node expr){
        this.bindings = bindings;
        this.identifier = identifier;
        this.expr = expr;
    }
    
    @Override
    public void execute() {
        /*try {
            bindings.put(identifier, expr.evaluate(bindings));
        } catch (SyntaxError e) {}*/
    }

}