import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int x : arr) {
            if (stack.isEmpty()) {
                stack.add(x);
                continue;
            }
            if (stack.peek() == x) {
                continue;
            }
            stack.add(x);
        }
        List<Integer> answer = new ArrayList<>();
        while(!stack.isEmpty()) {
            answer.add(stack.pop());
        }
        return answer.reversed().stream().mapToInt(i->i).toArray();
    }
}