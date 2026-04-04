import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int open1 = Integer.parseInt(stringTokenizer.nextToken());
        int open2 = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(bufferedReader.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.print(dfs(targets, 0, open1, open2, 0));
    }

    private static int dfs(int[] targets, int targetIdx, int open1, int open2, int cost) {
        if (targets.length == targetIdx) {
            return cost;
        }
        int target = targets[targetIdx];
        int min = Integer.MAX_VALUE;
        if ((open1 < target && target < open2) || open2 < target && target < open1) {
            min = Math.min(min, dfs(targets, targetIdx + 1, target, open2, cost + Math.abs(target - open1)));
            min = Math.min(min, dfs(targets, targetIdx + 1, open1, target, cost + Math.abs(target - open2)));
        } else {
            if (open2 <= target) {
                min = Math.min(min, dfs(targets, targetIdx + 1, open1, target, cost + Math.abs(target - open2)));
            } else {
                min = Math.min(min, dfs(targets, targetIdx + 1, target, open2, cost + Math.abs(target - open1)));
            }
        }
        return min;
    }
}