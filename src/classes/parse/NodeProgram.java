package classes.parse;

import java.util.ArrayList;
import java.util.List;

import interfaces.Node;

public class NodeProgram implements Node{

    List<Node> statements;

    public NodeProgram(){
        statements = new ArrayList<>();
    }

    @Override
    public int evaluate() throws SyntaxError {
        // TODO Auto-generated method stub
        for(Node statement: statements){
            statement.evaluate();
        }
        return 0;
    }
    
}
