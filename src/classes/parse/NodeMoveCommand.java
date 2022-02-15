package classes.parse;

import interfaces.Execute;
import interfaces.Unit;

public class NodeMoveCommand implements Execute{
    String direction;
    Unit unit;

    public NodeMoveCommand(String direction, Unit unit){
        this.direction =direction;
        this.unit = unit;
    }

    @Override
    public void execute() throws SyntaxError {
        //move direction
        // unit.move(x, y);
    }
    
}
