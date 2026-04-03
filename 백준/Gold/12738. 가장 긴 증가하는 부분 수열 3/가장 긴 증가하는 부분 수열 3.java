import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        List<Integer> sequence = new ArrayList<>();
        sequence.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int now = list.get(i);
            if (now > sequence.get(sequence.size() - 1)) {
                sequence.add(now);
            } else {
                sequence.set(binarySearch(sequence, now), now);
            }
        }
        System.out.print(sequence.size());
    }

    private static int binarySearch(List<Integer> sequence, int value) {
        int left = 0;
        int right = sequence.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sequence.get(mid) > value) {
                right = mid;
            } else if (sequence.get(mid) < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}