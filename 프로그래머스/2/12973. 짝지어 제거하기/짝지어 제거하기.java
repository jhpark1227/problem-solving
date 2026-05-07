import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
                continue;
            }
            stack.add(arr[i]);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}