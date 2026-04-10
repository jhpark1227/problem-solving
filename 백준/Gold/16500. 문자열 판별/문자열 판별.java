import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = bufferedReader.readLine();
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : words) {
                if (i >= word.length() && dp[i - word.length()]) {
                    if (s.substring(i - word.length(), i).equals(word)) {
                        dp[i] = true;
                    }
                }
            }
        }
        System.out.print(dp[s.length()] ? 1 : 0);
    }
}