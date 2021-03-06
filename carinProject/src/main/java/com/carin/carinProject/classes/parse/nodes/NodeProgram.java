package com.carin.carinProject.classes.parse.nodes;

import java.util.ArrayList;
import java.util.List;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.interfaces.Execute;

public class NodeProgram implements Execute{

    List<Execute> statements;

    public NodeProgram(){
        statements = new ArrayList<>();
    }

    public void addStatement(Execute statement){
        statements.add(statement);
    }

    @Override
    public void execute() throws SyntaxError {
        for(Execute statement: statements){
            statement.execute();
        }
    }
    
}
