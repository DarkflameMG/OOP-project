package interfaces;

import classes.parse.SyntaxError;

public interface Execute {

    /**
     * Execute node
     * @throws SyntaxError
     */
    void execute() throws SyntaxError;
}