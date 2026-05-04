import java.util.*;

class Solution {
    private int[] parents;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (e1, e2) -> e1[2] - e2[2]);
        parents = new int[n];
        for(int i=0;i<parents.length;i++) {
            parents[i] = i;
        }
        
        int answer = 0;
        for(int[] edge : costs) {
            if (find(edge[0]) == find(edge[1])) {
                continue;
            }
            union(edge[0], edge[1]);
            answer += edge[2];
        }
        return answer;
    }
    
    private int find(int child) {
        if (parents[child] != child) {
            parents[child] = find(parents[child]);
        }
        return parents[child];
    }
    
    private void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) {
            return;
        }
        if (aParent <= bParent) {
            parents[bParent] = aParent;
            return;
        }
        parents[aParent] = bParent;
    }
}