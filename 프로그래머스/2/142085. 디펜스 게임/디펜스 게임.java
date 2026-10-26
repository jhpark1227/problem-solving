import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        return binarySearch(n, k, enemy) + 1;
    }
    
    private int binarySearch(int n, int k, int[] enemy) {
        int left = 0;
        int right = enemy.length - 1;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (canWin(n, k, enemy, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    
    private boolean canWin(int n, int k, int[] enemy, int round) {
        int[] rounds = Arrays.copyOfRange(enemy, 0, round + 1);
        List<Integer> roundList = Arrays.stream(rounds)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .toList();
            
        
        for(int i=k;i<roundList.size();i++) {
            if (n < roundList.get(i)) return false;
            n -= roundList.get(i);
        }
        return true;
    }
}