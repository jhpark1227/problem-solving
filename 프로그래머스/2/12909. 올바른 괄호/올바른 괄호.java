import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] gwalhos = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char gwalho : gwalhos) {
            if (gwalho == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.add(gwalho);
        }
        return stack.isEmpty();
    }
}