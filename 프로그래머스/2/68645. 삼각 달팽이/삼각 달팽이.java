class Solution {
    
    private int[] dy = {1, 0, -1};
    private int[] dx = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int y = 0;
        int x = 0;
        int value = 1;
        int direction = 0;
        while (true) {
            triangle[y][x] = value++;
            int nextY = y + dy[direction];
            int nextX = x + dx[direction];
            if (nextY == n || nextY == -1 || nextX == n || nextX == -1 || triangle[nextY][nextX] != 0) {
                direction = (direction + 1) % 3;
                nextY = y + dy[direction];
                nextX = x + dx[direction];
                if (nextY == n || nextY == -1 || nextX == n || nextX == -1 || triangle[nextY][nextX] != 0) {
                    break;
                }
            }
            y = nextY;
            x = nextX;
        }
        
        int[] answer = new int[value-1];
        int index = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (triangle[i][j] == 0) continue;
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }
}