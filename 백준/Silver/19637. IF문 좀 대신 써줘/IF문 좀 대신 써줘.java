import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());

        List<Standard> standards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            standards.add(new Standard(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken())));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < d; i++) {
            int power = Integer.parseInt(bufferedReader.readLine());
            int index = binarySearch(standards, power);
            stringBuilder.append(standards.get(index).name).append("\n");
        }
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
    }

    private static int binarySearch(List<Standard> standards, int power) {
        int left = 0;
        int right = standards.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int limit = standards.get(mid).limit;
            if (power <= limit) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static class Standard {
        String name;
        int limit;

        public Standard(String name, int limit) {
            this.name = name;
            this.limit = limit;
        }
    }
}