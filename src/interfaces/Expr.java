package interfaces;
import java.util.Map;

public interface Expr extends Node{
    int eval(Map<String, Integer> bindings);
}