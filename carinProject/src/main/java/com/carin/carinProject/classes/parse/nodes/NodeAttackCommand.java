package com.carin.classes.parse.nodes;

import com.carin.classes.parse.SyntaxError;
import com.carin.interfaces.Execute;
import com.carin.interfaces.Node;
import com.carin.interfaces.Unit;

public class NodeAttackCommand implements Execute {
    private Node direction;
    private Unit unit;

    public NodeAttackCommand(Node direction, Unit unit){
        this.direction =direction;
        this.unit = unit;
    }

    @Override
    public void execute() throws SyntaxError {
        int direc = direction.evaluate(null);
        unit.attack(direc);
    }
}
