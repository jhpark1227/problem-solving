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
        List<Cow> cows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int arriveTime = Integer.parseInt(stringTokenizer.nextToken());
            int waitingTime = Integer.parseInt(stringTokenizer.nextToken());
            cows.add(new Cow(arriveTime, waitingTime));
        }

        cows.sort((a, b) -> a.arriveTime - b.arriveTime);
        int sum = 0;

        for (Cow cow : cows) {
            if (cow.arriveTime > sum) {
                sum = cow.arriveTime + cow.waitingTime;
            } else {
                sum += cow.waitingTime;
            }
        }
        System.out.println(sum);
    }

    private static class Cow {
        int arriveTime;
        int waitingTime;

        public Cow(int arriveTime, int waitingTime) {
            this.arriveTime = arriveTime;
            this.waitingTime = waitingTime;
        }
    }
}