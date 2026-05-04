import java.util.*;

class Solution {
    private int[] dy = {1, -1, 0, 0};
    private int[] dx = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        isVisited[0][0] = true;
        while(!q.isEmpty()) {
            Node now = q.poll();
            if (now.y == maps.length - 1 && now.x == maps[0].length - 1) {
                return now.depth;
            }
            for(int i=0;i<dy.length;i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (newY < 0 || newX < 0 || newY >= maps.length || newX >= maps[0].length || isVisited[newY][newX] || maps[newY][newX] == 0) continue;
                q.add(new Node(newY, newX, now.depth+1));
                isVisited[newY][newX] = true;
            }
        }
        return -1;
    }
    
    private class Node {
        int y;
        int x;
        int depth;
        
        Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}