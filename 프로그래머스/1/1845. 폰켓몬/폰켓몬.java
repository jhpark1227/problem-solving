import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet(Arrays.stream(nums).boxed().toList());
        return nums.length / 2 <= set.size() ? nums.length / 2 : set.size();
    }
}