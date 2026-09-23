import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int[] size : sizes) {
            if (size[0] > size[1]) {
                a.add(size[0]);
                b.add(size[1]);
            } else {
                a.add(size[1]);
                b.add(size[0]);
            }
        }
        int maxA = a.stream().mapToInt(i -> i).max().getAsInt();
        int maxB = b.stream().mapToInt(i -> i).max().getAsInt();
        
        return maxA * maxB;
    }
}