import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    private static final int INF = 50000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], INF);
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            distance[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean check = true;
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (distance[i][j] == INF && distance[j][i] == INF) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}