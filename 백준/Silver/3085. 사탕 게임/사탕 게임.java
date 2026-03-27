import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = bufferedReader.readLine().toCharArray();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.length <= i + 1) {
                    continue;
                }
                char tmp = board[i][j];
                board[i][j] = board[i + 1][j];
                board[i + 1][j] = tmp;
                max = Math.max(max, count(board));
                tmp = board[i][j];
                board[i][j] = board[i + 1][j];
                board[i + 1][j] = tmp;
                if (board[0].length <= j + 1) {
                    continue;
                }
                tmp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = tmp;
                max = Math.max(max, count(board));
                tmp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = tmp;
            }
        }
        System.out.println(max);
    }

    private static int count(char[][] board) {
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            int count = 1;
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j - 1] == board[i][j]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            int count = 1;
            for (int j = 1; j < board.length; j++) {
                if (board[j - 1][i] == board[j][i]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}