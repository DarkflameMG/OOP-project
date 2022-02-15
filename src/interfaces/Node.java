package interfaces;

import classes.SyntaxError;

public interface Node {
    /**
     * Evaluate node of each the node type 
     * @return the results of the evaluation
     * @throws SyntaxError
    */
    int evaluate() throws SyntaxError;

}