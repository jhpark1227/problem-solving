class Solution {
    public long solution(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        for(int i=4;i<=n;i+=2) {
            dp[i] = dp[i - 2] * 3;
            for(int j=0;j<=i-4;j+=2) {
                dp[i] = (dp[i] + dp[j] * 2) % 1_000_000_007;
            }
        }
        return dp[n];
    }
}