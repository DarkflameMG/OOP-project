package com.carin.interfaces;

import com.carin.classes.parse.TokenizerError;

public interface Tokenizer {

    /** 
     * Get the next token  
     * @return next token
    */
    String peek();

    /**
     * Return token and remove that 
     * @return current token
     * @throws TokenizerError if unknown token has been found
     */
    String consume() throws TokenizerError;
    
}
