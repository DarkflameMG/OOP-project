package com.carin.carinProject.classes.parse;

import com.carin.carinProject.classes.AntiBodyImp;
import com.carin.carinProject.classes.parse.nodes.BinaryArithmetic;
import com.carin.carinProject.interfaces.Unit;

public class TestMain{

    public static String printexp (BinaryArithmetic s){
        StringBuilder a = new StringBuilder();
        s.prettyPrint(a);
        System.out.println("Expression: "+ a);
        return a.toString();
    }
    
    public static void main(String[] args) throws TokenizerError, SyntaxError {
        // GeneticGrammar gen = GeneticGrammar.getInstance();
    String test = "virusLoc = virus" +
    "if (virusLoc / 10 - 1)" +
    "then" +
    "if (virusLoc % 10 - 7) then move upleft" +
    "else if (virusLoc % 10 - 6) then move left" +
    "else if (virusLoc % 10 - 5) then move downleft" +
    "else if (virusLoc % 10 - 4) then move down" +
    "else if (virusLoc % 10 - 3) then move downright" +
    "else if (virusLoc % 10 - 2) then move right" +
    "else if (virusLoc % 10 - 1) then move upright" +
    "else move up" +
    "else if (virusLoc)" +
    "then # virus nearby" +
    "if (virusLoc % 10 - 7) then shoot upleft" +
    "else if (virusLoc % 10 - 6) then shoot left" +
    "else if (virusLoc % 10 - 5) then shoot downleft" +
    "else if (virusLoc % 10 - 4) then shoot down" +
    "else if (virusLoc % 10 - 3) then shoot downright" +
    "else if (virusLoc % 10 - 2) then shoot right" +
    "else if (virusLoc % 10 - 1) then shoot upright" +
    "else shoot up" +
    "else # no virus; move in a random direction" +
    "{" +
    "dir = random % 8" +
    "if (dir - 6) then move upleft" +
    "else if (dir - 5) then move left" +
    "else if (dir - 4) then move downleft" +
    "else if (dir - 3) then move down" +
    "else if (dir - 2) then move downright" +
    "else if (dir - 1) then move right" +
    "else if (dir) then move upright" +
    "else move up" +
    "}";

    // GeneticGrammar t = new GeneticGrammar(test);
    String s = "x = 2^3^2";
//    GeneticGrammar l = new GeneticGrammar("2");
//    GeneticGrammar r = new GeneticGrammar("5");
//    BinaryArithmetic lr = new BinaryArithmetic(l.parseExpression(), r.parseExpression(), "+");
//    TestMain.printexp(lr);
//    GeneticGrammar g = new GeneticGrammar(s);
//    Node e = g.parseExpression();
//        System.out.println(e.evaluate());
        Unit host = new AntiBodyImp("Cox");
        GeneticGrammar t1 = new GeneticGrammar(s,host);
        t1.parseProgram();
        t1.run();
        System.out.println("Hello");
    }

}
