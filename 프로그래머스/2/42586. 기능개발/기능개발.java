import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int index = 0;
        List<Integer> answer = new ArrayList<>();
        while(index < progresses.length) {
            int date = (100 - progresses[index]) / speeds[index];
            if ((100 - progresses[index]) % speeds[index] != 0) date++;
            for(int i=0;i<progresses.length;i++) {
                progresses[i] += speeds[i] * date;
            }
            int count = 0;
            for(int i=index;i<progresses.length;i++) {
                if (progresses[i] >= 100) {
                    count++;
                    index++;
                } else {
                    break;
                }
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}