import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[8 + 1];
        for(int i=0;i<=8;i++) {
            dp[i] = new HashSet<>();
        }
        for(int i=1;i<=8;i++) {
            String tmp = "";
            for(int j=0;j<i;j++) {
                tmp += N;
            }
            dp[i].add(Integer.parseInt(tmp));
            for(int j=1;j<i;j++) {
                for(int a : dp[j]) {
                    for (int b : dp[i - j]) {
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