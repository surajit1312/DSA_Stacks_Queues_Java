package basics;

import java.util.Stack;

/**
 * 
 * GeeksForGeeks: Parenthesis Checker
 * 
 * Link: https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
 * 
 * TC: O(N)
 * SC: O(N)
 * 
 */
public class P3_Valid_Parenthesis {
    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
        boolean isValid = hasBalancedParenthesis(exp);
        System.out.println("Expression " + exp + " has balanced parenthesis : " + isValid);
    }

    private static boolean hasBalancedParenthesis(String x) {
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : x.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character current = stack.pop();
                if (getOpenBracketForClosed(ch) != current) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private static Character getOpenBracketForClosed(Character ch) {
        Character open;
        switch (ch) {
            case ')':
                open = '(';
                break;
            case '}':
                open = '{';
                break;
            case ']':
                open = '[';
                break;
            default:
                open = null;
                break;
        }
        return open;
    }

    private static boolean isOpenBracket(Character ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
}
