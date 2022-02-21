package com.carin.carinProject.classes.parse;

import com.carin.carinProject.interfaces.Tokenizer;

import java.util.HashSet;
import java.util.Set;

public class ExprTokenizer implements  Tokenizer{
    private String src;
    private String next;
    private int pos;
    private Set<Character> ch = new HashSet<>();


    public ExprTokenizer(String src) throws SyntaxError, TokenizerError {
        ch.add('+');ch.add('-');ch.add('*');ch.add('/');ch.add('%');ch.add('(');ch.add(')');
        ch.add('{');ch.add('}');ch.add('=');
        this.src = src;
        pos = 0;
        computeNext();
    }

    private void computeNext() throws TokenizerError{
        StringBuilder s = new StringBuilder();
        while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) pos++;  // ignore whitespace
        if (pos < src.length()) {
            char c = src.charAt(pos);
            if (Character.isDigit(c)) {  // start of number
                s.append(c);
                for (pos++; pos < src.length() &&
                        Character.isDigit(src.charAt(pos)); pos++)
                    s.append(src.charAt(pos));
            } else if (Character.isLetter(c)) {  // start of string
                while( pos < src.length() && !Character.isWhitespace(src.charAt(pos)) && !ch.contains(src.charAt(pos)))
                {
                    c = src.charAt(pos);
                    s.append(c);
                    pos++;
                }
            }
            else if(ch.contains(c)){
                s.append(c);
                pos++;
            } else throw new TokenizerError("Unknown: " + c);
        }
        next = s.toString();
    }

    public boolean peek(String s){
        if(!src.isEmpty()) return peek().equals(s);
        return false;
    }

    public void consume(String s) throws TokenizerError {
        if(peek(s)) {
            consume();
        }else
            throw new TokenizerError("Unknown: " + s);
    }

    @Override
    public String peek() { return next; }

    @Override
    public String consume() throws TokenizerError {
        String result = next;
        computeNext();
        return result;
    }

}
