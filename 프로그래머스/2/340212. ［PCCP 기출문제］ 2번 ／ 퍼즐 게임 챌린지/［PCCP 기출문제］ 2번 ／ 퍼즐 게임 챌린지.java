import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        return binarySearch(diffs, times, limit);
    }
    
    private int binarySearch(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        while(left < right) {
            int mid = (left + right) / 2;
            long time = calculateTime(diffs, times, mid);
            if (time <= limit) {
                right = mid;
                continue;
            }
            if (time > limit) {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private long calculateTime(int[] diffs, int[] times, int level) {
        final int n = diffs.length;
        long totalTime = times[0];
        if (diffs[0] > level) {
            totalTime += (diffs[0] - level) * times[0];
        }
        for(int i=1;i<n;i++) {
            if (diffs[i] > level) {
                totalTime += (diffs[i] - level) * (times[i - 1] + times[i]);
            }
            totalTime += times[i];
        }
        return totalTime;
    }
}