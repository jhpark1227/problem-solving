import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        for(String[] options : clothes) {
            String name = options[0];
            String type = options[1];
            if (!map.keySet().contains(type)) {
                map.put(type, new ArrayList<>());
            }
            map.get(type).add(name);
        }
        for(List<String> names : map.values()) {
            answer *= (names.size() + 1);
        }
        return answer - 1;
    }
}