import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> strs = new ArrayList(Arrays.stream(numbers)
            .boxed()
            .map(String::valueOf)
            .toList());
        strs.sort((a, b) -> {
            String strA = String.valueOf(a);
            String strB = String.valueOf(b);
            return (strB+strA).compareTo(strA+strB);
        });
        if (strs.get(0).equals("0")) {
            return "0";
        }
        return strs.stream().reduce("", String::concat);
    }
}