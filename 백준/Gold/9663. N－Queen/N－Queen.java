import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] queenIndexes = new int[n];
        dfs(queenIndexes, 0);
        System.out.println(count);
    }

    private static void dfs(int[] queenIndexes, int index) {
        if (index == queenIndexes.length) {
            count++;
            return;
        }
        for (int i = 0; i < queenIndexes.length; i++) {
            queenIndexes[index] = i;
            boolean isDuplicated = false;
            for (int j = 0; j < index; j++) {
                if (queenIndexes[j] == i || Math.abs(queenIndexes[j] - i) == index - j) {
                    isDuplicated = true;
                }
            }
            if (!isDuplicated) {
                dfs(queenIndexes, index + 1);
            }
        }
    }
}