package bodlogo22;

import java.util.*;

public class Solution {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return "NO";
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return "NO";
                }
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";
    }
    
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '{' && close == '}')
            || (open == '[' && close == ']');
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            System.out.println(isBalanced(s));
        }
        
        sc.close();
    }
}
