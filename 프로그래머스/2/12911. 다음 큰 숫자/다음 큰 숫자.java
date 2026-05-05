class Solution {
    public int solution(int n) {
        int count = countOne(Integer.toBinaryString(n));
        while(n <= 1_000_000) {
            n++;
            if (countOne(Integer.toBinaryString(n)) == count) {
                return n;
            }
        }
        return -1;
    }
    
    int countOne(String binary) {
        int count = 0;
        for(char c : binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}