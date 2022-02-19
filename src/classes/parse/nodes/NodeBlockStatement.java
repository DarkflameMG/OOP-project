package classes.parse.nodes;

import java.util.ArrayList;
import java.util.List;

import classes.parse.SyntaxError;
import interfaces.Execute;

public class NodeBlockStatement implements Execute{
    
    List<Execute> statements;

    public NodeBlockStatement(){
        statements = new ArrayList<>();
    }

    public void addBlockStatement(Execute statement){
        statements.add(statement);
    }

    @Override
    public void execute() throws SyntaxError {
        for(Execute statement: statements){
            statement.execute();
        }
    }
}

