package classes.parse;

import interfaces.Execute;
import interfaces.Node;

public class NodeWhileStatement implements Execute{
    Execute statement;
    Node expr;

    public NodeWhileStatement(Execute statement, Node expr){
        this.statement = statement;
        this.expr = expr;
    }

    @Override
    public void execute() throws SyntaxError {
        while(expr.evaluate()>0){
            statement.execute();
        }
    }
    
    
}
