package classes.parse;

import interfaces.Execute;
import interfaces.Unit;

public class NodeAttackCommand implements Execute {
    String direction;
    Unit unit;

    public NodeAttackCommand(String direction, Unit unit){
        this.direction =direction;
        this.unit = unit;
    }

    @Override
    public void execute() throws SyntaxError {
        //attack in direction??  or attack target??
        // unit.attack(target);
    }
}
