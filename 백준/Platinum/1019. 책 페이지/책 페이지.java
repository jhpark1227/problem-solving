import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] count = new int[10];
        for (int i = 0; i < String.valueOf(n).length(); i++) {
            int d = (int) Math.pow(10, i);
            int high = n / (d * 10);
            int curr = n / d % 10;
            int low = n % d;
            for (int j = 0; j <= 9; j++) {
                if (curr == j) {
                    count[j] += high * d + low + 1;
                } else if (curr > j) {
                    count[j] += (high + 1) * d;
                } else {
                    count[j] += high * d;
                }
            }
            count[0] -= d;
        }
        for (int i : count) {
            System.out.print(i + " ");
        }
    }
}