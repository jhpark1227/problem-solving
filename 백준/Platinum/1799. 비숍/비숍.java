import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int n;
    private static boolean[][] canMove;
    private static boolean[][] isVisited;
    private static int[] dy = {-1, -1};
    private static int[] dx = {-1, 1};
    private static int black = 0;
    private static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        canMove = new boolean[n][n];
        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                canMove[i][j] = stringTokenizer.nextToken().equals("1");
            }
        }

        dfs(0, 0, 0);
        if (n > 1) {
            dfs(0, 1, 0);
        }
        System.out.print(black + white);
    }

    private static void dfs(int y, int x, int count) {
        if (y == n) {
            if ((y + x) % 2 == 0) {
                black = Math.max(black, count);
            } else {
                white = Math.max(white, count);
            }
            return;
        }
        int newY = y;
        int newX = x + 2;
        if (newX >= n) {
            newY++;
            if ((y + x) % 2 == newY % 2) {
                newX = 0;
            } else {
                newX = 1;
            }
        }
        if (!canMove[y][x]) {
            dfs(newY, newX, count);
            return;
        }

        if (canMove(y, x)) {
            isVisited[y][x] = true;
            dfs(newY, newX, count + 1);
            isVisited[y][x] = false;
        }

        dfs(newY, newX, count);
    }

    private static boolean canMove(int y, int x) {
        for (int i = 0; i < dy.length; i++) {
            int newY = y;
            int newX = x;

            while (true) {
                newY = newY + dy[i];
                newX = newX + dx[i];
                if (newY == n || newY < 0 || newX == n || newX < 0) {
                    break;
                }
                if (isVisited[newY][newX]) {
                    return false;
                }
            }
        }
        return true;
    }
}