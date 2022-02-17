package classes.parse;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import interfaces.Execute;
import interfaces.Node;
import interfaces.Unit;

public class GeneticGrammar {
    private final ExprTokenizer tknz;
    private Map<String, Integer> bindings;
    private Unit unit;
    
    public GeneticGrammar(String src) throws SyntaxError, TokenizerError{
        this.tknz = new ExprTokenizer(src);
    }

    private final String[] directionList = {"left", "right", "up", "down", "upleft", "upright", "downleft", "downright"};
    private final Set<String> directions = new HashSet<>(List.of(directionList));
    

    //Program → Statement+
    public Execute parseProgram() throws TokenizerError, SyntaxError{
        return null;
        // NodeProgram p = new NodeProgram();
        // p.addStatement(parseStatement());
        // while(!tknz.consume().equals("")){           //next tknz is statement
        //     p.addStatement(parseStatement());
        // }
        // return p;
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
    public Execute parseAssignmentStatement() throws TokenizerError, SyntaxError{
        String identifier = tknz.peek();       
        tknz.consume("=");
        Node expr = parseExpression();
        return new NodeAssignmentStatement(bindings, identifier, expr);
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
        String move_direction = tknz.consume();
        if(directions.contains(move_direction)){
            return new NodeMoveCommand(move_direction, unit);
        }else{
            throw new SyntaxError("Unknown direction: "+ move_direction);
        }
    }

    //AttackCommand → shoot Direction
    public Execute parseAttackCommand() throws TokenizerError, SyntaxError{
        tknz.consume("shoot");
        String shoot_direction = tknz.consume();
        if(directions.contains(shoot_direction)){
            return new NodeAttackCommand(shoot_direction, unit);
        }else{
            throw new SyntaxError("Unknown direction: "+ shoot_direction);
        }
    }

    //Direction → left | right | up | down | upleft | upright | downleft | downright
    public Execute parseDirection(){
        return null;
    }

    //BlockStatement → { Statement* }
    public Execute parseBlockStatement() throws TokenizerError, SyntaxError{
        NodeBlockStatement nb = new NodeBlockStatement();
        tknz.consume("{");
        while(!tknz.peek("}")){
            nb.addBlockStatement(parseStatement()); 
            //tknz.consume("}");
        }
        tknz.consume("}");
        return nb;
    }

    //IfStatement → if ( Expression ) then Statement else Statement
    public Execute parseIfStatement() throws TokenizerError, SyntaxError{
        tknz.consume("if");
        tknz.consume("(");
        Node expr = parseExpression();
        tknz.consume(")");
        tknz.consume("then");
        Execute statementTrue = parseStatement();  
        tknz.consume("else"); 
        if(tknz.peek("if")){              //case: else if
            parseIfStatement();
        }
        Execute statementFalse = parseStatement();
        return new NodeIfStatement(statementTrue, statementFalse, expr);
    }

    //WhileStatement → while ( Expression ) Statement
    public Execute parseWhileStatement() throws TokenizerError, SyntaxError{
        tknz.consume("while");
        tknz.consume("(");
        Node expr = parseExpression();
        tknz.consume(")");
        Execute statement = parseStatement();
        return new NodeWhileStatement(statement, expr);
    }

    //Expression → Expression + Term | Expression - Term | Term
    public Node parseExpression() throws TokenizerError, SyntaxError{
        Node term = parseTerm();
        while(tknz.peek("+")|| tknz.peek("-")){
            String operator = tknz.consume();
            term = new BinaryArithmetic(term, parseTerm(), operator);
        }
        return term;
    }

    //Term → Term * Factor | Term / Factor | Term % Factor | Factor
    public Node parseTerm() throws TokenizerError, SyntaxError{
        Node factor = parseFactor();
        while(tknz.peek("*") || tknz.peek("/") || tknz.peek("%")){
            String operator = tknz.consume();
            factor = new BinaryArithmetic(factor, parseFactor(), operator);
        }
        return factor;
    }

    //Factor → Power ^ Factor | Power
    public Node parseFactor() throws TokenizerError, SyntaxError{
        Node pw = parsePower();
        while(tknz.peek("^")){
            String operator = tknz.consume();
            pw = new BinaryArithmetic(pw, parsePower(), operator);;
        }
        return pw;
    }

    //Power → <number> | <identifier> | ( Expression ) | SensorExpression
    public Node parsePower() throws TokenizerError, SyntaxError{
        if(isNumber(tknz.peek()) > 0)
        {
            return new Number(Integer.parseInt(tknz.consume()));
        }
        else if(tknz.peek("("))
        {
            tknz.consume("(");
            Node e = parseExpression();
            tknz.consume(")");
            return e;
        }
        else
        {
            return null;
        }
    }

    private int isNumber(String s)
    {
        if(s == null || s.equals(""))
            return 0;
        try {
            int a = Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
        return 1;
    }

    //SensorExpression → virus | antibody | nearby Direction
    public Execute parseSsensorExpression() throws TokenizerError, SyntaxError{
        return null;
    }
}
