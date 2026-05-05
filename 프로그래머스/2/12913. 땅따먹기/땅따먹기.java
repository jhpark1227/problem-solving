class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        dp[0] = land[0];
        for(int i=1;i<land.length;i++) {
            for(int j=0;j<4;j++) {
                for(int k=0;k<4;k++) {
                    if (k == j) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }
        int answer = 0;
        for(int i=0;i<4;i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }
}