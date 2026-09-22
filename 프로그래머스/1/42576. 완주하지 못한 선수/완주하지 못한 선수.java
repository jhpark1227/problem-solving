import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<>();
        for(String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }
        for(String completion : completions) {
            if (map.get(completion) == 1) {
                map.remove(completion);
                continue;
            }
            map.put(completion, map.get(completion) - 1);
        }
        return map.keySet().stream().toList().get(0);
    }
}