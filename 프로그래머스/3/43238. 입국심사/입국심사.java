class Solution {
    private static final long MAX = 1_000_000_000;
    
    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }
    
    private long binarySearch(int n, int[] times) {
        long left = 0;
        long right = MAX * MAX;
        while(left < right) {
            long mid = (left + right) / 2;
            if (isPossible(n, mid, times)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean isPossible(int n, long limit, int[] times) {
        long sum = 0;
        for(int time : times) {
            sum += limit / time;
        }
        return sum >= n;
    }
}