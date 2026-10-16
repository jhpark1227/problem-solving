import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<number.length();i++) {
            while(!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.add(number.charAt(i));
        }
        for(int i=0;i<k;i++) {
            stack.pop();
        }
        String answer = "";
        while(!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}