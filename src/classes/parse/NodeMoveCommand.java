package classes.parse;

import interfaces.Execute;
import interfaces.Node;
import interfaces.Unit;

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
        // unit.move(x, y);
    }
    
}
