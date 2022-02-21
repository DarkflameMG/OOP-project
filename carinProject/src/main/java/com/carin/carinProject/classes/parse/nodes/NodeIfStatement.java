package main.java.com.carin.carinProject.classes.parse.nodes;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;
import main.java.com.carin.carinProject.interfaces.Node;
import main.java.com.carin.carinProject.interfaces.Execute;

import java.util.Map;


public class NodeIfStatement implements Execute{
    Execute statementTrue;
    Execute statementFalse;
    Node expr;
    Map<String, Integer> bindings;

    public NodeIfStatement (Execute statementTrue, Execute statementFalse, Node expr, Map<String, Integer> bindings){
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