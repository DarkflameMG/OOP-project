package main.java.com.carin.carinProject.classes.parse.nodes;

import java.util.Map;

import main.java.com.carin.carinProject.interfaces.Execute;
import main.java.com.carin.carinProject.interfaces.Node;

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