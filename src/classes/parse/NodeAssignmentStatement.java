package classes.parse;

import java.util.Map;

import interfaces.Execute;
import interfaces.Node;

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
        try {
            bindings.put(identifier, expr.evaluate());
        } catch (SyntaxError e) {}
    }

}