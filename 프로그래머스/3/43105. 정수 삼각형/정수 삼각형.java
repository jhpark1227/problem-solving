import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        for(int i=0;i<triangle.length;i++) {
            for(int j=0;j<triangle[i].length;j++) {
                dp[i][j] = triangle[i][j];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i][j]);
                }
                if (i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j] + triangle[i][j], dp[i][j]);   
                }
            }
        }
        return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
    }
}