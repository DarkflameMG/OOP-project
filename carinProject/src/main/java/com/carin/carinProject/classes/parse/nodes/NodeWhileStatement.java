package com.carin.classes.parse.nodes;

import com.carin.classes.parse.SyntaxError;
import com.carin.interfaces.Execute;
import com.carin.interfaces.Node;

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
