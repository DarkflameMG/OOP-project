package classes.parse.nodes;

import classes.parse.SyntaxError;
import interfaces.Node;
import interfaces.Execute;

import java.util.Map;


public class NodeIfStatement implements Execute{
    Execute statementTrue;
    Execute statementFalse;
    Node expr;
    Map<String, Node> bindings;

    public NodeIfStatement (Execute statementTrue, Execute statementFalse, Node expr, Map<String, Node> bindings){
        this.statementTrue = statementTrue;
        this.statementFalse = statementFalse;
        this.expr = expr;
        this.bindings = bindings;
    }
    
    @Override
    public void execute() throws SyntaxError {
        if(expr.evaluate(bindings)<=0){
            statementFalse.execute();
        }else if(expr.evaluate(bindings)>0){
            statementTrue.execute();
        }
    }   
}