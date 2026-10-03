import java.util.*;

class Solution {
    
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbersStr) {
        List<Integer> numbers = numbersStr.chars()
            .map(i -> (int)i - '0')
            .boxed()
            .toList();
        dfs(numbers, new boolean[numbers.size()], 0);
        return set.size();
    }
    
    private boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for(int i=2;i<=(int)Math.sqrt(number);i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private void dfs(List<Integer> numbers, boolean[] isVisited, int now) {
        if(isPrime(now)) {
            set.add(now);
        }
        for(int i=0;i<numbers.size();i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            dfs(numbers, isVisited, now * 10 + numbers.get(i));
            isVisited[i] = false;
        }
    }
}