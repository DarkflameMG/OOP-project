package com.carin.classes.parse.nodes;

import com.carin.classes.parse.SyntaxError;
import com.carin.interfaces.Execute;
import com.carin.interfaces.Node;
import com.carin.interfaces.Unit;

public class NodeMoveCommand implements Execute{
    private Node direction;
    private Unit unit;

    public NodeMoveCommand(Node direction, Unit unit){
        this.direction =direction;
        this.unit = unit;
    }

    @Override
    public void execute() throws SyntaxError {
        //move direction
        int direc = direction.evaluate(null);
        unit.move(direc);
    }
    
}
