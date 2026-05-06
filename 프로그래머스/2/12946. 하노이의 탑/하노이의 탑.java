import java.util.*;

class Solution {
    List<int[]> answer = new ArrayList<>();
    public int[][] solution(int n) {
        move(1, 3, n);
        int[][] arr = new int[answer.size()][2];
        for(int i=0;i<arr.length;i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }
    
    private void move(int from, int to, int n) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        boolean[] check = new boolean[4];
        check[from] = true;
        check[to] = true;
        for(int i=1;i<4;i++) {
            if(!check[i]) {
                move(from, i, n - 1);
                move(from, to, 1);
                move(i, to, n - 1);
            }
        }
    }
}