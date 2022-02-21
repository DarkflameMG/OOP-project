package main.java.com.carin.carinProject.classes.parse.nodes;

import java.util.ArrayList;
import java.util.List;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;
import main.java.com.carin.carinProject.interfaces.Execute;

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

