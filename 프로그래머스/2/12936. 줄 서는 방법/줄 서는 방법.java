import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long total = 1;
        for(int i=2;i<=n;i++) {
            total *= i;
        }
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            numbers.add(i);
        }
        int[] answer = new int[n];
        for(int i=0;i<n;i++) {
            long div = total / (n - i);
            int index = (int)((k - 1)/ div);
            k -= index * div;
            answer[i] = numbers.get(index);
            numbers.remove(index);
            if (numbers.isEmpty()) break;
            total /= (n - i);
        }
        return answer;
    }
}