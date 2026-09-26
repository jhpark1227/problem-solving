import java.util.*;
import java.util.stream.*;

class Solution {
    private final int[] bPattern = {1, 3, 4, 5};
    private final int[] cPattern = {3, 1, 2, 4, 5};
    
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        for(int i=0;i<answers.length;i++) {
            int a = i % 5 + 1;
            int b = i % 2 == 0 ? 2 : bPattern[i / 2 % 4];
            int c = cPattern[i / 2 % 5];
            if (a == answers[i]) count[0]++;
            if (b == answers[i]) count[1]++;
            if (c == answers[i]) count[2]++;
        }
        int max = Arrays.stream(count).max().getAsInt();
        return IntStream.range(1, 4)
            .filter(i -> count[i-1] == max)
            .sorted()
            .toArray();
    }
}