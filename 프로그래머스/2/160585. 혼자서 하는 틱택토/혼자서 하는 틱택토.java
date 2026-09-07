class Solution {
    
    private boolean possible = false;
    
    public int solution(String[] board) {
        char[][] ttt = new char[board.length][board[0].length()];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length();j++) {
                ttt[i][j] = board[i].charAt(j);
            }    
        }
        char[][] current = new char[board.length][board[0].length()];
        for(int i=0;i<current.length;i++) {
            for(int j=0;j<current[0].length;j++) {
                current[i][j] = '.';
            }    
        }
        dfs(ttt, current, 1);
        
        return possible ? 1: 0;
    }
    
    
    private void dfs(char[][] ttt, char[][] current, int turn) {
        if (isSame(ttt, current)) {
            possible = true;
            return;
        }
        if (isEnd(current)){
            return;
        }
        
        
        if (turn == 10) return;
        
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if (current[i][j] != '.') continue;
                if (turn % 2 == 0) {
                    current[i][j] = 'X';
                } else {
                    current[i][j] = 'O';
                }
                dfs(ttt, current, turn + 1);
                current[i][j] = '.';
            }
        }
    }
    
    private boolean isEnd(char[][] board) {
        for(int i=0;i<3;i++) {
            if ((board[i][0] == 'O' || board[i][0] == 'X') && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        for(int i=0;i<3;i++) {
            if ((board[0][i] == 'O' || board[0][i] == 'X') && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        if ((board[0][0] == 'O' || board[0][0] == 'X') && board[0][0] == board[1][1] && board[0][0] == board[2][2]) return true;
        if ((board[2][0] == 'O' || board[2][0] == 'X') && board[2][0] == board[1][1] && board[2][0] == board[0][2]) return true;
        return false;
    }
    
    private boolean isSame(char[][] a, char[][] b) {
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<b[0].length;j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}