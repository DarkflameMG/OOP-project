package main.java.com.carin.carinProject.classes.parse.nodes;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;
import main.java.com.carin.carinProject.interfaces.Execute;
import main.java.com.carin.carinProject.interfaces.Node;
import main.java.com.carin.carinProject.interfaces.Unit;

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
