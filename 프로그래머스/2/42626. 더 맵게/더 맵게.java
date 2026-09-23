import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for(int scoville : scovilles) {
            pq.add(scoville);
        }
        int answer = 0;
        while(pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}