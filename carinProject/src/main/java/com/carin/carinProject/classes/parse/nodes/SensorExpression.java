package com.carin.carinProject.classes.parse.nodes;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.interfaces.Node;
import com.carin.carinProject.interfaces.Unit;

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
        if(host.equals("antibody") || host.equals("virus")){
            return unit.Sensor();
        }
        else if(host.equals("nearby")){
            return unit.SensorNearby(direction.evaluate(bindings));
        }
        return -1;
    }

}
