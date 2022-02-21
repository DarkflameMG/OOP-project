package com.carin.interfaces;

import com.carin.classes.parse.SyntaxError;

public interface Execute {

    /**
     * Execute node
     * @throws SyntaxError
     */
    void execute() throws SyntaxError;
}