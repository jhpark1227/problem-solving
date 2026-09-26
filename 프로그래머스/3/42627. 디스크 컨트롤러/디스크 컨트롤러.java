import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Task> tasks = new ArrayList<>();
        for(int i=0;i < jobs.length;i++) {
            tasks.add(new Task(i, jobs[i][0], jobs[i][1]));
        }
        tasks.sort((a, b) -> a.requestTime - b.requestTime);
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.duration != b.duration) {
                return a.duration - b.duration;
            }
            if (a.requestTime != b.requestTime) {
                return a.requestTime - b.requestTime;
            }
            return a.number - b.number;
        });
        int index = 0;
        int sum = 0;
        int time = 0;
        int count = 0;
        while(count< tasks.size()) {
            while (index < tasks.size() && tasks.get(index).requestTime <= time) {
                pq.add(tasks.get(index));
                index++;
            }
            if (!pq.isEmpty() && time >= pq.peek().requestTime) {
                Task task = pq.poll();
                time += task.duration;
                sum += time - task.requestTime;
                count++;
                continue;
            } 
            time++;
        }
        return sum / tasks.size();
    }
    
    private static class Task {
        int number;
        int duration;
        int requestTime;
        
        private Task(int number, int requestTime, int duration) {
            this.number = number;
            this.duration = duration;
            this.requestTime = requestTime;
        }
    }
}