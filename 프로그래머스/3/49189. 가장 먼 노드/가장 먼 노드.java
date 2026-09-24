import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new List[n+1];
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int max = 0;
        int maxCount = 1;
        int[] dist = bfs(graph);
        for(int i=2;i<dist.length;i++) {
            if (dist[i] > max) {
                max = dist[i];
                maxCount = 1;
                continue;
            }
            if (dist[i] ==max) {
                maxCount++;
                continue;
            }
        }
        return maxCount;
    }
    
    private int[] bfs(List<Integer>[] graph) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        boolean[] isVisited = new boolean[graph.length];
        isVisited[1] = true;
        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            distances[now.value] = now.depth;
            for(int next : graph[now.value]) {
                if (isVisited[next]) continue;
                q.add(new Node(next, now.depth + 1));
                isVisited[next] = true;
            }
        }
        return distances;
    }
    
    private static class Node {
        int value;
        int depth;
        
        private Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}