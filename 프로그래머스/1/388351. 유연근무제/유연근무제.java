class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        for(int i=0;i<timelogs.length;i++) {
            int dayOfWeek = startday;
            int[] timelog = timelogs[i];
            int worktime = schedules[i];
            boolean success = true;
            for(int time: timelog) {
                if (dayOfWeek == 6 || dayOfWeek == 7) {
                    dayOfWeek = dayOfWeek % 7 + 1;
                    continue;
                }
                int limit = worktime + 10;
                if (limit % 100 >= 60) {
                    limit += 40;
                }
                if (time > limit) {
                    success = false;
                    break;
                }
                dayOfWeek = (dayOfWeek + 1) % 7;
            }
            if (success) {
                result++;
            }
        }
        return result;
    }
}