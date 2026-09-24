class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    private int dfs(int[] numbers, int index, int value, int target) {
        int n = numbers[index];
        if (index == numbers.length - 1) {
            if (value + n == target || value - n == target) {
                return 1;
            }   
            return 0;
        }
        return dfs(numbers, index + 1, value + n, target) + dfs(numbers, index + 1, value - n, target);
    }
}