package main.java.com.carin.carinProject.classes.parse.nodes;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;
import main.java.com.carin.carinProject.interfaces.Node;
import main.java.com.carin.carinProject.interfaces.Unit;

import java.util.Map;

public class SensorExpression implements Node{
    Unit unit;
    String host;
    Node direction;

    public SensorExpression(Unit unit,String host, Node direction){
        this.unit = unit;
        this.host = host;
        this.direction = direction;
    }

    @Override
    public int evaluate(Map<String,Integer> bindings) throws SyntaxError {
        if(host.equals("antibody")){
            return 1;
        }
        else if(host.equals("virus")){
            return -1;
        }
        else{
            return 0;
        }
    }

}
