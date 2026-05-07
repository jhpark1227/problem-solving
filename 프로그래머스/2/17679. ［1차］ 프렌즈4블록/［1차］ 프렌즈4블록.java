class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] blocks = new char[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
        while(true) {
            boolean[][] deleted = new boolean[m][n];
            int count = 0;
            for(int i=1;i<m;i++) {
                for(int j=1;j<n;j++) {
                    if (blocks[i][j] != 'x' && blocks[i - 1][j - 1] == blocks[i][j] && blocks[i - 1][j] == blocks[i][j] && blocks[i][j - 1] == blocks[i][j]) {
                        deleted[i-1][j-1] = true;
                        deleted[i-1][j] = true;
                        deleted[i][j-1] = true;
                        deleted[i][j] = true;
                        count++;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                int index = m - 1;
                for(int j=m-1;j>=0;j--) {
                    if (deleted[j][i]) {
                        continue;
                    }
                    blocks[index][i] = blocks[j][i];
                    index--;
                }
                for(int j=index;j>=0;j--) {
                    blocks[j][i] = 'x';
                }
            }
            if (count ==0) break;
        }
        int answer = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (blocks[i][j] == 'x') {
                    answer++;
                }
            }
        }
        return answer;
    }
}