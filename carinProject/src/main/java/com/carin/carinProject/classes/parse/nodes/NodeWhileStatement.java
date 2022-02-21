package main.java.com.carin.carinProject.classes.parse.nodes;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;
import main.java.com.carin.carinProject.interfaces.Execute;
import main.java.com.carin.carinProject.interfaces.Node;

import java.util.Map;

public class NodeWhileStatement implements Execute{
    Execute statement;
    Node expr;
    Map<String, Integer> bindings;

    public NodeWhileStatement(Execute statement, Node expr, Map<String, Integer> bindings){
        this.statement = statement;
        this.expr = expr;
        this.bindings = bindings;
    }

    @Override
    public void execute() throws SyntaxError {
        while(expr.evaluate(bindings)>0){
            statement.execute();
        }
    }
    
    
}
