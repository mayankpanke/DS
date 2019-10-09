package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedExpression {
    static Map<Character, Character> closingToStarting = Map.of(']','[','}','{',')', '(');
    public static void main(String[] args) {
        boolean balanced = findBalanced("[()]{}{[()()]()}");
        System.out.println(balanced);
    }

    private static boolean findBalanced(String s) {
        char[] symbols = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(Character symbol : symbols){
            if(closingSymbol(symbol)){
                Character startingSymbol = stack.pop();
                if(startingSymbol == null || closingToStarting.get(symbol) == null || closingToStarting.get(symbol) != startingSymbol){
                    return false;
                }
            } else {
                stack.push(symbol);
            }
        }
        return true;
    }

    private static boolean closingSymbol(Character symbol) {
        return symbol == ')' || symbol == ']' || symbol == '}';
    }
}
