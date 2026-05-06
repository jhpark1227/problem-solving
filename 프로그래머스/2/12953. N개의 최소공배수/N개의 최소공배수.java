class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1;i<arr.length;i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}