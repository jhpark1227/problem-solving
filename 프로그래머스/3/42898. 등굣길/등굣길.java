class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        for(int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (i==0&&j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                int top = 0;
                int left = 0;
                if (i != 0) top = dp[i - 1][j];
                if (j != 0) left = dp[i][j - 1];
                dp[i][j] = (top + left) % 1_000_000_007;
            }
        }

        return dp[n - 1][m - 1];
    }
}