import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        for(int i=0;i<dp.length;i++) {
            dp[i] = new HashSet<>();
        }
        int concat = 0;
        for(int i=1;i<=8;i++){
            concat = concat * 10 + N;
            dp[i].add(concat);
            for(int j=1;j<i;j++) {
                Set<Integer> set1 = dp[j];
                Set<Integer> set2 = dp[i - j];
                for(int a : set1) {
                    for(int b : set2) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b == 0) continue;
                        dp[i].add(a / b);       
                    }
                }
            }
            if (dp[i].contains(number)) return i;
        }
        return -1;
    }
}