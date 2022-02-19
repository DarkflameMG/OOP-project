package classes.parse.nodes;

import classes.parse.SyntaxError;
import interfaces.Execute;
import interfaces.Node;
import interfaces.Unit;

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
