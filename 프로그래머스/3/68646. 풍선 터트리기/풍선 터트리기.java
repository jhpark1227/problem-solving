class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] leftStart = new int[n];
        int[] rightStart = new int[n];
        leftStart[0] = a[0];
        rightStart[n - 1] = a[n - 1];
        for(int i=1;i<n;i++) {
            leftStart[i] = Math.min(leftStart[i - 1], a[i]);
            rightStart[n - i - 1] = Math.min(rightStart[n - i], a[n - i - 1]);
        }
        int count = 0;
        for(int i=0;i<n;i++) {
            if(leftStart[i] == a[i] || rightStart[i] == a[i]) count++;
        }
        return count;
    }
}