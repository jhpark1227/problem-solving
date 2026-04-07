import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        String[] bridge = {bufferedReader.readLine(), bufferedReader.readLine()};
        int[][][] dp = new int[bridge[0].length()][2][string.length()];

        for (int i = 0; i < bridge[0].length(); i++) {
            if (bridge[0].charAt(i) == string.charAt(0)) {
                dp[i][0][0] = 1;
            }
            if (bridge[1].charAt(i) == string.charAt(0)) {
                dp[i][1][0] = 1;
            }
        }

        for (int i = 1; i < bridge[0].length(); i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < string.length(); k++) {
                    if (bridge[j].charAt(i) == string.charAt(k)) {
                        int pb = 1 - j;
                        for (int l = 0; l < i; l++) {
                            dp[i][j][k] += dp[l][pb][k - 1];
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < bridge[0].length(); i++) {
            sum += dp[i][0][string.length() - 1];
            sum += dp[i][1][string.length() - 1];
        }
        System.out.print(sum);
    }
}