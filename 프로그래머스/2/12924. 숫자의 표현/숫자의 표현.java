class Solution {
    public int solution(int n) {
        int[] sum = new int[10001];
        for(int i=1;i<sum.length;i++) {
            sum[i] = sum[i - 1] + i;
        }
        int count = 0;
        int left = 0;
        int right = 1;
        while(left < right) {
            if (sum[right] - sum[left] == n) {
                count++;
            }
            if (sum[right] - sum[left] <= n) {
                right++;
            }
            if (sum[right] - sum[left] > n) {
                left++;
            }
        }
        return count;
    }
}