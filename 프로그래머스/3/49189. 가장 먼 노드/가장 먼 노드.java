import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new List[n + 1];
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        int[] distance = bfs(graph);
        int max = Arrays.stream(distance)
            .max()
            .getAsInt();
        return (int) Arrays.stream(distance)
            .filter(x -> x == max)
            .count();
    }
    
    private int[] bfs(List<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] distance = new int[graph.length + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : graph[now]) {
                if (distance[next] != -1) {
                    continue;
                }
                distance[next] = distance[now] + 1;
                q.add(next);
            }
        }
        return distance;
    }
}