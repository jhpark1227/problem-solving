import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = {scores[0][0], scores[0][1]};
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        int count = scores[0][0] + scores[0][1] > wanho[0] + wanho[1] ? 1 : 0;
        int max = scores[0][1];
        for (int i = 1; i < scores.length; i++) {
            if (max > scores[i][1]) {
                if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) {
                    return -1;
                }
                continue;
            }
            if (scores[i][0] + scores[i][1] > wanho[0] + wanho[1]) {
                count++;
            }
            max = Math.max(max, scores[i][1]);
        }
        return count + 1;
    }
}