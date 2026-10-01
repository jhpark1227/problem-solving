import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> increasePq = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> decreasePq = new PriorityQueue<>((a, b) -> b - a);
        for(String op : operations) {
            String command = op.split(" ")[0];
            int number = Integer.parseInt(op.split(" ")[1]);
            if ("I".equals(command)) {
                increasePq.add(number);
                decreasePq.add(number);
                continue;
            }
            if (number == 1) {
                increasePq.remove(decreasePq.poll());
            }
            if (number == -1) {
                decreasePq.remove(increasePq.poll());
            }
        }
        if (increasePq.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{decreasePq.peek(), increasePq.peek()};
    }
}