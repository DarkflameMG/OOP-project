package classes.parse;

import interfaces.Node;
import interfaces.Execute;


public class NodeIfStatement implements Execute{
    Execute statementTrue;
    Execute statementFalse;
    Node expr;

    public NodeIfStatement (Execute statementTrue, Execute statementFalse, Node expr){
        this.statementTrue = statementTrue;
        this.statementFalse = statementFalse;
        this.expr = expr;
    }
    
    @Override
    public void execute() {
        if(expr.evaluate()<=0){
            statementFalse.execute();
        }else if(expr.evaluate()>0){
            statementTrue.execute();
        }
    }   
}