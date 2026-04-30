import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] arrive = new int[timetable.length];
        for(int i=0;i<timetable.length;i++) {
            int h = Integer.parseInt(timetable[i].split(":")[0]);
            int minute = Integer.parseInt(timetable[i].split(":")[1]);
            arrive[i] = h * 60 + minute;
        }
        Arrays.sort(arrive);
        int minute = 60 * 9;
        int waiting = 0;
        int con = 0;
        for(int i=0;i<n;i++) {
            int onBusCount = 0;
            while(waiting < arrive.length && arrive[waiting] <= minute && onBusCount < m) {
                waiting++;
                onBusCount++;
            }
            if (onBusCount == m) {
                con = arrive[waiting - 1] - 1;
            }
            if (onBusCount < m) {
                con = minute;
            }
            minute += t;
        }
        return String.format("%02d:%02d", con / 60, con % 60);
    }
}