package interfaces;

import classes.parse.SyntaxError;

public interface Node {
    /**
     * Evaluate node of each the node type 
     * @return the results of the evaluation
     * @throws SyntaxError
    */
    int evaluate() throws SyntaxError;

}