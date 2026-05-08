import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        cities = Arrays.stream(cities).map(i -> i.toLowerCase()).toArray(String[]::new);
        List<String> cache = new ArrayList<>();
        int answer = 0;
        for(String city : cities) {
            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
                continue;
            }
            if (cacheSize > 0) {
                if (!cache.isEmpty() && cacheSize == cache.size()) {
                    cache.remove(0);   
                }
                cache.add(city);    
            }
            answer+=5;
        }
        return answer;
    }
}