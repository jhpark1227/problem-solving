import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int h = Integer.parseInt(stringTokenizer.nextToken());
        int[] bottomhurdleCounts = new int[h + 1];
        int[] tophurdleCounts = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(bufferedReader.readLine());
            if (i % 2 == 0) {
                bottomhurdleCounts[height]++;
            } else {
                tophurdleCounts[h - height + 1]++;
            }
        }
        for (int i = 1; i <= h; i++) {
            tophurdleCounts[i] += tophurdleCounts[i - 1];
        }
        for (int i = h - 1; i >= 1; i--) {
            bottomhurdleCounts[i] += bottomhurdleCounts[i + 1];
        }
        int[] hurdleCounts = new int[h + 1];
        for (int i = 1; i <= h; i++) {
            hurdleCounts[i] += bottomhurdleCounts[i];
            hurdleCounts[i] += tophurdleCounts[i];
        }
        Arrays.sort(hurdleCounts);
        int count = 1;
        for (int i = 2; i < hurdleCounts.length; i++) {
            if (hurdleCounts[i] == hurdleCounts[i - 1]) {
                count++;
            } else {
                break;
            }
        }
        System.out.print(hurdleCounts[1] + " " + count);
    }
}