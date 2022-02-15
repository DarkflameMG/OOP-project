package interfaces;

import classes.parse.TokenizerError;

public interface Tokenizer {

    /** 
     * Get the next token  
     * @return next token
    */
    String peek();

    /**
     * Get the current token
     * @return current token
     * @throws TokenizerError if unknown token has been found
     */
    String consume() throws TokenizerError;
    
}
