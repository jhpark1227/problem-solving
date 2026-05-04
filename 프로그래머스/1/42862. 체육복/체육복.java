class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] losted = new boolean[n + 1];
        boolean[] reserved = new boolean[n + 1];
        for(int i=0;i<lost.length;i++) {
            losted[lost[i]] = true;
        }
        for(int i=0;i<reserve.length;i++) {
            if(losted[reserve[i]]) {
                losted[reserve[i]] = false;
                continue;
            }
            reserved[reserve[i]] = true;
        }
        
        for(int i=1;i<=n;i++) {
            if (reserved[i]) {
                if(losted[i - 1]) {
                    losted[i - 1] = false;
                    continue;
                }
                if(i + 1 < losted.length && losted[i + 1]) {
                    losted[i + 1] = false;
                }
            }
        }
        int count = 0;
            for(int i=1;i<losted.length;i++) {
                if (!losted[i]) count++;
            }
        return count;
    }
}