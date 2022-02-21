package main.java.com.carin.carinProject.interfaces;

import main.java.com.carin.carinProject.classes.parse.SyntaxError;

public interface Execute {

    /**
     * Execute node
     * @throws SyntaxError
     */
    void execute() throws SyntaxError;
}