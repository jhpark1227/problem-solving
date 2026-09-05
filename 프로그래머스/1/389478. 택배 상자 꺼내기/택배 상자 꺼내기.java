class Solution {
    public int solution(int n, int w, int num) {
        int targetHeight = (num - 1) / w + 1;
        int targetPosition = (num - 1) % w + 1;
        int totalHeight = (n - 1) / w + 1;
        int totalPosition = (n - 1) % w + 1;
        int answer = totalHeight - targetHeight;
        if (totalHeight % 2 == targetHeight % 2) {
            if (targetPosition <= totalPosition) {
                answer++;
            }
        } else {
            if (targetPosition > w - totalPosition) {
                answer++;
            }
        }
        return answer;
    }
}