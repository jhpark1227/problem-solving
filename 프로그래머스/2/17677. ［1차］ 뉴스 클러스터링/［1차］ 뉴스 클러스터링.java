import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> a = createMap(str1);
        Map<String, Integer> b = createMap(str2);
        Map<String, Integer> x = new HashMap<>();
        Map<String, Integer> y = new HashMap<>();
        for(String key : a.keySet()) {
            if (b.keySet().contains(key)) {
                x.put(key, Math.min(a.get(key), b.get(key)));
                y.put(key, Math.max(a.get(key), b.get(key)));
                continue;
            }
            y.put(key, a.get(key));
        }
        for(String key : b.keySet()) {
            if (a.keySet().contains(key)) {
                continue;
            }
            y.put(key, b.get(key));
        }
        int xCount = x.values().stream().mapToInt(i->i).sum();
        int yCount = y.values().stream().mapToInt(i->i).sum();
        if (yCount == 0) {
            return 65536;
        }
        return (int)((double)xCount / yCount * 65536);
    }
    
    private Map<String, Integer> createMap(String a) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<a.length()-1;i++) {
            char first = a.charAt(i);
            char second = a.charAt(i + 1);
            if (first < 'a' || first > 'z' || second < 'a' || second > 'z') {
                continue;
            }
            map.merge(a.substring(i, i + 2), 1, (x, y) -> x + y);
        }
        return map;
    }
}