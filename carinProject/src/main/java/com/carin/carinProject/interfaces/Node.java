package com.carin.carinProject.interfaces;

import com.carin.carinProject.classes.parse.SyntaxError;

import java.util.Map;

public interface Node {
    /**
     * Evaluate node of each the node type 
     * @return the results of the evaluation
     * @param bindings a Map bind variable and value
     * @throws SyntaxError
    */
    int evaluate(Map<String,Integer> bindings) throws SyntaxError;

}