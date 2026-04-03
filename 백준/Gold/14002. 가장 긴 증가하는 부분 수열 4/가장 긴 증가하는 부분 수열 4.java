import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(max + "\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (dp[i] == max) {
                stack.add(numbers[i]);
                max--;
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop()).append(" ");
        }
        System.out.print(stringBuilder);
    }
}