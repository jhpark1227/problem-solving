import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] counts = new int[n + 1];
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int before = Integer.parseInt(stringTokenizer.nextToken());
            int after = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(before).add(after);
            counts[after]++;
        }
        for (List<Integer> firsts : graph.values()) {
            Collections.sort(firsts);
        }

        List<Integer> sequence = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[n + 1];
        for (Integer i : graph.keySet()) {
            if (counts[i] == 0) {
                pq.add(i);
                isVisited[i] = true;
            }
        }
        while (!pq.isEmpty()) {
            Integer now = pq.poll();
            sequence.add(now);
            for (Integer i : graph.get(now)) {
                counts[i]--;
                if (counts[i] == 0 && !isVisited[i]) {
                    pq.add(i);
                    isVisited[i] = true;
                }
            }
        }

        for (Integer i : sequence) {
            System.out.print(i + " ");
        }
    }
}