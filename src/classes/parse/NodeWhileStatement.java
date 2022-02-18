package classes.parse;

import interfaces.Execute;
import interfaces.Node;

import java.util.Map;

public class NodeWhileStatement implements Execute{
    Execute statement;
    Node expr;
    Map<String, Node> bindings;

    public NodeWhileStatement(Execute statement, Node expr, Map<String, Node> bindings){
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
