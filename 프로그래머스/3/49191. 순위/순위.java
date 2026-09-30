import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];
        for(int[] result : results) {
            win[result[0]][result[1]] = true;
        }
        floydWarshall(win);
        
        int answer = 0;
        for(int i=1;i<=n;i++) {
            int count = 0;
            for(int j=1;j<=n;j++) {
                if (win[i][j]) count++;
                if (win[j][i]) count++;
            }
            if (count == n - 1) {
                answer++;
            }
        }
        return answer;
    }
    
    private void floydWarshall(boolean[][] win) {
        for(int k=1;k<win.length;k++) {
            for(int i=1;i<win.length;i++) {
                for(int j=1;j<win.length;j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
    }
}