import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++) {
            if (set.contains(words[i]) || words[i].length() == 1 || (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) ) {
                return new int[]{(i+1) % n == 0 ? n : (i+1) % n, i / n + 1};
            }
            set.add(words[i]);
        }

        return new int[]{0, 0};
    }
}