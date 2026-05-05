class Solution {
    public int solution(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        int max = 0;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}