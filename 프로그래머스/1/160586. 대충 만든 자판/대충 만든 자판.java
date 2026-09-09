import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Keymap> list = new ArrayList<>();
        for(String km : keymap) {
            list.add(new Keymap(km));
        }
        List<Integer> answer = new ArrayList<>();
        for(String target : targets) {
            boolean possible = true;
            int count = 0;
            for(char c : target.toCharArray()) {
                int min = Integer.MAX_VALUE;
                for(Keymap key : list) {
                    if (key.get(c) == null) continue;
                    min = Math.min(min, key.get(c));
                }
                if (min == Integer.MAX_VALUE) {
                    possible = false;
                    break;
                }
                count += min;
            }
            if (!possible) {
                answer.add(-1);
                continue;
            }
            answer.add(count);
        }
        return answer.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
    
    private class Keymap {
        Map<Character, Integer> map;
        
        private Keymap(String rawKeymap) {
            Map<Character, Integer> map = new HashMap<>();
            for(int i=1;i<=rawKeymap.length();i++) {
                if (map.keySet().contains(rawKeymap.charAt(i-1))) {
                    continue;
                }
                map.put(rawKeymap.charAt(i-1), i);
            }
            this.map = map;
        }
        
        private Integer get(char c) {
            return map.get(c);
        }
    }
}