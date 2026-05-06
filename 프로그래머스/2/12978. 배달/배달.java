import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<Edge>[] graph = new List[N + 1];
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] r : road) {
            graph[r[0]].add(new Edge(r[1], r[2])); 
            graph[r[1]].add(new Edge(r[0], r[2])); 
        }
        int[] distance = new int[N + 1];
        Arrays.fill(distance, 100_000_000);
        distance[1] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distance[a] - distance[b]);
        pq.add(1);
        
        while(!pq.isEmpty()) {
            int now = pq.poll();
            for(Edge next : graph[now]) {
                if (distance[now] + next.cost < distance[next.dest]) {
                    distance[next.dest] = distance[now] + next.cost;
                    pq.add(next.dest);
                }
            }
        }
        int count = 0;
        for(int i=1;i<=N;i++) {
            if (distance[i] <= K) {
                count++;
            }
        }
        return count;
    }
    
    private static class Edge {
        int dest;
        int cost;
        
        Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}