import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int sLength = Integer.parseInt(stringTokenizer.nextToken());
        int pLength = Integer.parseInt(stringTokenizer.nextToken());
        String s = bufferedReader.readLine();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int aMinCount = Integer.parseInt(stringTokenizer.nextToken());
        int cMinCount = Integer.parseInt(stringTokenizer.nextToken());
        int gMinCount = Integer.parseInt(stringTokenizer.nextToken());
        int tMinCount = Integer.parseInt(stringTokenizer.nextToken());

        int aCount = 0, cCount = 0, gCount = 0, tCount = 0;
        for (int i = 0; i < pLength; i++) {
            if (s.charAt(i) == 'A') {
                aCount++;
            }
            if (s.charAt(i) == 'C') {
                cCount++;
            }
            if (s.charAt(i) == 'G') {
                gCount++;
            }
            if (s.charAt(i) == 'T') {
                tCount++;
            }
        }
        int result = 0;
        if (aCount >= aMinCount && cCount >= cMinCount && gCount >= gMinCount && tCount >= tMinCount) {
            result++;
        }
        for (int i = pLength; i < sLength; i++) {
            if (s.charAt(i - pLength) == 'A') {
                aCount--;
            }
            if (s.charAt(i - pLength) == 'C') {
                cCount--;
            }
            if (s.charAt(i - pLength) == 'G') {
                gCount--;
            }
            if (s.charAt(i - pLength) == 'T') {
                tCount--;
            }
            if (s.charAt(i) == 'A') {
                aCount++;
            }
            if (s.charAt(i) == 'C') {
                cCount++;
            }
            if (s.charAt(i) == 'G') {
                gCount++;
            }
            if (s.charAt(i) == 'T') {
                tCount++;
            }
            if (aCount >= aMinCount && cCount >= cMinCount && gCount >= gMinCount && tCount >= tMinCount) {
                result++;
            }
        }
        System.out.println(result);
    }
}