package interfaces;

import classes.SyntaxError;

public interface Execute {

    /**
     * Execute node
     * @throws SyntaxError
     */
    void execute() throws SyntaxError;
}