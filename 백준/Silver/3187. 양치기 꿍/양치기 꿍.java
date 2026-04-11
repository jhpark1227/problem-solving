import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int wolf = 0;
    private static int sheep = 0;
    private static int surviedWolf = 0;
    private static int surviedSheep = 0;
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        char[][] area = new char[r][c];
        for (int i = 0; i < r; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                area[i][j] = input.charAt(j);
            }
        }

        boolean[][] isVisited = new boolean[area.length][area[0].length];
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                if (isVisited[i][j]) {
                    continue;
                }
                isVisited[i][j] = true;
                dfs(i, j, isVisited, area);
                if (sheep > wolf) {
                    surviedSheep += sheep;
                } else {
                    surviedWolf += wolf;
                }
                wolf = 0;
                sheep = 0;
            }
        }

        System.out.println(surviedSheep + " " + surviedWolf);
    }

    private static void dfs(int y, int x, boolean[][] isVisited, char[][] area) {
        if (area[y][x] == 'v') {
            wolf++;
        }
        if (area[y][x] == 'k') {
            sheep++;
        }
        for (int i = 0; i < dy.length; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY < 0 || newY >= area.length || newX < 0 || newX >= area[0].length || isVisited[newY][newX] || area[newY][newX] == '#') {
                continue;
            }
            isVisited[newY][newX] = true;
            dfs(newY, newX, isVisited, area);
        }
    }
}