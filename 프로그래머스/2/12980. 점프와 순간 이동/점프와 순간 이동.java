import java.util.*;

public class Solution {
    public int solution(int n) {
        int cost = 0;
        while(n != 0) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            n--;
            cost++;
        }
        return cost;
    }
}