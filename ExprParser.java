public class ExprParser {
    private final ExprTokenizer tknz;

    public ExprParser(String src){
        this.tknz = new ExprTokenizer(src);
    }
    
    public Expr parseProgram(){
        Expr s = parseStatement();
        return s;
    }

    public Expr parseStatement(){
        return null;
    }
    public Expr parseCommand(){
        return null;
    }
    public Expr parseAssignmentStatement(){
        return null;
    }
    public Expr parseSEnsorCommand(){
        return null;
    }
    public Expr parseActionCommand(){
        return null;
    }
    public Expr parseMoveCommand(){
        return null;
    }
    public Expr parseAttackCommand(){
        return null;
    }
    public Expr parseDirection(){
        return null;
    }
    public Expr parseBlockStatement(){
        return null;
    }
    public Expr parseIfStatement(){
        return null;
    }
    public Expr parseWhileStatement(){
        return null;
    }
    public Expr parseExpression(){
        return null;
    }
    public Expr parseTerm(){
        return null;
    }
    public Expr parseFactor(){
        return null;
    }
    public Expr parsePower(){
        return null;
    }

}
