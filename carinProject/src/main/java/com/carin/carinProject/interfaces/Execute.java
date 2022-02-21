package com.carin.carinProject.interfaces;

import com.carin.carinProject.classes.parse.SyntaxError;

public interface Execute {

    /**
     * Execute node
     * @throws SyntaxError
     */
    void execute() throws SyntaxError;
}