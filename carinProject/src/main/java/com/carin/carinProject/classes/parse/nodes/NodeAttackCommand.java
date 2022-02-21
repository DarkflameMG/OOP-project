package com.carin.carinProject.classes.parse.nodes;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.interfaces.Execute;
import com.carin.carinProject.interfaces.Node;
import com.carin.carinProject.interfaces.Unit;

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
