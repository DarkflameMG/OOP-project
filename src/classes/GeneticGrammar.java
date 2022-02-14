package classes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import interfaces.Execute;
import interfaces.Node;

public class GeneticGrammar {
    private final ExprTokenizer tknz;

    public GeneticGrammar(String src){
        this.tknz = ExprTokenizer.getInstance();
    }
    
    private final String[] directionList = {"left", "right", "up", "down", "upleft", "upright", "downleft", "downright"};
    private final Set<String> directions = new HashSet<>(List.of(directionList));

    //Program → Statement+
    public Execute parseProgram(){
        return null;
    }

    //Statement → Command | BlockStatement | IfStatement | WhileStatement
    public Execute parseStatement() throws TokenizerError, SyntaxError{
        if(tknz.peek("{")){
            return parseBlockStatement();
        }else if(tknz.peek("if")){
            return parseIfStatement();
        }else if(tknz.peek("while")){
            return parseWhileStatement();
        }else{ 
            return parseCommand();
        }
    }

    //Command → AssignmentStatement | ActionCommand
    public Execute parseCommand() throws TokenizerError, SyntaxError{
        if(tknz.peek("move") || tknz.peek("shoot")){
            return parseActionCommand();
        }
        return parseAssignmentStatement();
    }

    //AssignmentStatement → <identifier> = Expression
    public Execute parseAssignmentStatement(){
        return null;
    }
    public Execute parseSensorCommand(){
        return null;
    }

    //ActionCommand → MoveCommand | AttackCommand
    public Execute parseActionCommand() throws TokenizerError, SyntaxError{
        if(tknz.peek("move")){
            return parseMoveCommand();
        }else if(tknz.peek("shoot")){
            return parseAttackCommand();
        }
        return null;
    }

    //MoveCommand → move Direction
    public Execute parseMoveCommand() throws TokenizerError, SyntaxError{
        tknz.consume("move");
        if(directions.contains(tknz.consume())){
            return null;
        }else{
            throw new SyntaxError("Unknown direction word");
        }
        // return null;
    }

    //AttackCommand → shoot Direction
    public Execute parseAttackCommand() throws TokenizerError, SyntaxError{
        tknz.consume("shoot");
        if(directions.contains(tknz.consume())){
            return null;
        }else{
            throw new SyntaxError("Unknown direction word");
        }
        // return null;
    }

    //Direction → left | right | up | down | upleft | upright | downleft | downright
    public Execute parseDirection(){
        return null;
    }

    //BlockStatement → { Statement* }
    public Execute parseBlockStatement() throws TokenizerError{
        tknz.consume("{");
        
        return null;
    }

    //IfStatement → if ( Expression ) then Statement else Statement
    public Execute parseIfStatement(){
        return null;
    }

    //WhileStatement → while ( Expression ) Statement
    public Execute parseWhileStatement(){

        return null;
    }

    //Expression → Expression + Term | Expression - Term | Term
    public Node parseExpression(){
        return null;
    }

    //Term → Term * Factor | Term / Factor | Term % Factor | Factor
    public Node parseTerm(){
        return null;
    }

    //Factor → Power ^ Factor | Power
    public Node parseFactor(){
        Node pw = parsePower();
        while(tknz.peek("^")){
            String opr = tknz.consume();
            // power = ;
        }
        return pw;
    }

    //Power → <number> | <identifier> | ( Expression ) | SensorExpression
    public Node parsePower(){
        return null;
    }

    //SensorExpression → virus | antibody | nearby Direction
    public Execute parseSsensorExpression(){
        return null;
    }

}
