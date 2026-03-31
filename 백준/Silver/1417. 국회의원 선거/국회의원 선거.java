import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int dasom = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            priorityQueue.add(Integer.parseInt(bufferedReader.readLine()));
        }
        int count = 0;
        while (!priorityQueue.isEmpty() && priorityQueue.peek() >= dasom) {
            int max = priorityQueue.poll();
            dasom++;
            priorityQueue.add(max - 1);
            count++;
        }
        System.out.println(count);
    }
}