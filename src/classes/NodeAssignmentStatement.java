package classes;

import java.util.Map;

import interfaces.Execute;
import interfaces.Node;

public class NodeAssignmentStatement implements Execute{

    Map<String, Integer> bindings;
    String identifier;
    Node expr;

    public NodeAssignmentStatement(Map<String, Integer> bindings, String identifier, Node expr){
        
    }
    @Override
    public void execute() {
        bindings.put(identifier, (int) expr.evaluate());
    }

}