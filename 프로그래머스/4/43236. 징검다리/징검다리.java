import java.util.*;

class Solution {
    public int solution(int distance, int[] rockArr, int n) {
        List<Integer> rocks = new ArrayList<>(Arrays.stream(rockArr).boxed().toList());
        rocks.add(0, 0);
        rocks.add(distance);
        Collections.sort(rocks);
        
        return binarySearch(0, distance, rocks, n);
    }
    
    private int binarySearch(int left, int right, List<Integer> rocks, int n) {
        while(left < right) {
            int mid = (left + right + 1) / 2;
            if (temp(mid, rocks, n)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private boolean temp(int mid, List<Integer> rocks, int n) {
        int count = 0;
        int index = 1;
        int prev = rocks.get(0);
        while (index < rocks.size()) {
            int distance = rocks.get(index) - prev;
            if (distance < mid) {
                count++;
            } else {
                prev = rocks.get(index);
            }
            index++;
        }
        if (count > n) {
            return false;
        }
        return true;
    }
}

