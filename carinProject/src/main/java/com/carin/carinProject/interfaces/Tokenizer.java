package main.java.com.carin.carinProject.interfaces;

import main.java.com.carin.carinProject.classes.parse.TokenizerError;

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
