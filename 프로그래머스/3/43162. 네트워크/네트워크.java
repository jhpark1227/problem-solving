import java.util.*;

class Solution {
    
    private boolean[] isVisited;
    
    public int solution(int n, int[][] computers) {
        List<Integer>[] graph = new List[n];
        isVisited = new boolean[n];
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (computers[i][j] == 0) continue;
                graph[i].add(j);
                graph[j].add(i);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++) {
            if (isVisited[i]) continue;
            dfs(graph, i);
            count++;
        }
        
        return count;
    }
    
    private void dfs(List<Integer>[] graph, int current) {
        isVisited[current] = true;
        for(int next : graph[current]) {
            if (isVisited[next]) continue;
            dfs(graph, next);
        }
    }
}