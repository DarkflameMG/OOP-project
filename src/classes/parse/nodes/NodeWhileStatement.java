package classes.parse.nodes;

import classes.parse.SyntaxError;
import interfaces.Execute;
import interfaces.Node;

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
