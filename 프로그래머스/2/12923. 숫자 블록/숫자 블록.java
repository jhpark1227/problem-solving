class Solution {
    public int[] solution(long begin, long end) {
        int[] blocks = new int[(int)(end - begin + 1)];
        for(long i=begin;i<=end;i++) {
            int max = 0;
            for(int j=1;j<=Math.sqrt(i);j++) {
                if (i % j != 0) continue;
                if(j != i && j <= 10000000) {
                    max = Math.max(max, (int)j);      
                }
                if (i / j != i && i / j <= 10000000) {
                    max = Math.max(max, (int)(i / j));      
                }
            }
            blocks[(int)(i - begin)] = max;
        }
        return blocks;
    }
}