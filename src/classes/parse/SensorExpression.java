package classes.parse;

import interfaces.Node;

import java.util.Map;

public class SensorExpression implements Node{
    String obj;
    String direction;

    public SensorExpression(String obj, String direction){
        this.obj = obj;
        this.direction = direction;
    }

    @Override
    public int evaluate(Map<String,Node> bindings) throws SyntaxError {
        if(obj.equals("antibody")){
            return 1;
        }
        else if(obj.equals("virus")){
            return -1;
        }
        else{               
            return 0;
        }
    }

}
