import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long x = Integer.parseInt(stringTokenizer.nextToken());
        long y = Integer.parseInt(stringTokenizer.nextToken());
        long winRate = y * 100 / x;
        if (winRate >= 99) {
            System.out.println(-1);
            return;
        }
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right) / 2;
            if ((y + mid) * 100 / (x + mid) > winRate) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}