import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int v = Integer.parseInt(stringTokenizer.nextToken());
        int e = Integer.parseInt(stringTokenizer.nextToken());
        long[][] distance = new long[v + 1][v + 1];
        for (int i = 0; i < distance.length; i++) {
            long[] ints = new long[v + 1];
            Arrays.fill(ints, 400 * 400 * 10000);
            distance[i] = ints;
        }
        for (int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            distance[a][b] = c;
        }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }
        long answer = 400 * 400 * 10000;
        for (int i = 1; i <= v; i++) {
            answer = Math.min(answer, distance[i][i]);
        }
        System.out.println(answer == 400 * 400 * 10000 ? -1 : answer);
    }
}