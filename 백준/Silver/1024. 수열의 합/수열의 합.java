import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int l = Integer.parseInt(stringTokenizer.nextToken());

        for (int length = l; length <= 100; length++) {
            int min = 0;
            int sum = length * (length - 1) / 2;
            while (true) {
                if (sum > n) {
                    break;
                } else if (sum == n) {
                    for (int i = min; i < min + length; i++) {
                        System.out.print(i + " ");
                    }
                    return;
                }
                sum += length;
                min++;
            }
        }
        System.out.println(-1);
    }
}