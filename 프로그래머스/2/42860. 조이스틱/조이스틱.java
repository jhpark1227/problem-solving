class Solution {
    public int solution(String name) {
        int upDownCount = 0;
        for(int i=0;i<name.length();i++) {
            char c = name.charAt(i);
            upDownCount += Math.min(c - 'A', 'Z' - c + 1);
        }
        int leftRightCount = Integer.MAX_VALUE;
        int n = name.length();
        for(int i=0;i<n;i++) {
            int x = i + 1;
            while(x < n && name.charAt(x) == 'A') {
                x++;
            }
            leftRightCount = Math.min(leftRightCount, Math.min(i*2 + (n - x), i + 2 * (n - x)));
        }
        return upDownCount + leftRightCount;
    }
}