class Solution {
    public int solution(int[][] signals) {
        int[] colors = new int[signals.length];
        int[] counts = new int[signals.length];
        int tmp = 1;
        for(int i=0;i<signals.length;i++) {
            colors[i] = 0;
            counts[i] = signals[i][0];
            tmp *= signals[i][0] + signals[i][1] + signals[i][2];
        }
        for(int i=1;i<=tmp;i++) {
            for(int j=0;j<signals.length;j++) {
                counts[j]--;
                if (counts[j] == 0) {
                    colors[j]++;
                    if(colors[j] == 3) {
                        colors[j] = 0;
                    }
                    counts[j] = signals[j][colors[j]];
                }
            }
            boolean check = true;
            for(int j=0;j<signals.length;j++) {
                if (colors[j] != 1){
                    check = false;
                    break;
                }
            }
            if (check) {
                return i + 1;
            }
        }
        return -1;
    }
}