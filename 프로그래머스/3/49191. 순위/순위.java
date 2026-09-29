import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<Integer>[] winGraph = new List[n + 1];
        List<Integer>[] loseGraph = new List[n + 1];
        for(int i=0;i<winGraph.length;i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }
        for(int[] result : results) {
            winGraph[result[0]].add(result[1]);
            loseGraph[result[1]].add(result[0]);
        }
        
        int answer = 0;
        for(int i=1;i<=n;i++) {
            boolean[] isVisited = new boolean[n + 1];
            isVisited[i] = true;
            int winCount = count(winGraph, i, isVisited) - 1;
            isVisited = new boolean[n + 1];
            isVisited[i] = true;
            int loseCount = count(loseGraph, i, isVisited) - 1;
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }
        return answer;
    }
    
    private int count(List<Integer>[] graph, int start, boolean[] isVisited) {
        int sum = 1;
        for(int next : graph[start]) {
            if (isVisited[next]) continue;
            isVisited[next] = true;
            sum += count(graph, next, isVisited);
        }
        return sum;
    }
}