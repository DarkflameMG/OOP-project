package com.carin.classes.parse.nodes;

import com.carin.classes.parse.SyntaxError;
import com.carin.interfaces.Node;
import com.carin.interfaces.Execute;

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