import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer> list = Arrays.stream(priorities)
            .boxed()
            .toList();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(list);
        Queue<Integer> q = new LinkedList<>(list);
        int count = 1;
        while(!q.isEmpty()) {
            int now = q.poll();
            if (pq.peek() == now) {
                if (location == 0) {
                    break;
                }
                pq.poll();
                count++;
                location--;
                continue;
            }
            q.add(now);
            if (location == 0) {
                location = q.size() - 1;
            } else {
                location--;
            }
        }
        return count;
    }
}