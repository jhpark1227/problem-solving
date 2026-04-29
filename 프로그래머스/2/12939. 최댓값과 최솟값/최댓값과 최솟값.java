class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++) {
            int number = Integer.parseInt(numbers[i]);
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        return min + " " + max;
    }
}