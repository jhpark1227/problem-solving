import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] graph = new int[101][101];
        for(int[] rec : rectangle) {
            for(int i=rec[0] * 2;i<=rec[2] * 2;i++) {
                graph[rec[1] * 2][i] = 1;
                graph[rec[3] * 2][i] = 1;
            }
            for(int i=rec[1] * 2;i<=rec[3] * 2;i++) {
                graph[i][rec[0] * 2] = 1;
                graph[i][rec[2] * 2] = 1;
            }
            for(int i=rec[1] * 2 + 1;i<rec[3] * 2;i++) {
                for(int j=rec[0] * 2 + 1;j<rec[2] * 2;j++) {
                    graph[i][j] = 2;
                }
            }
        }
        
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph[0].length;j++) {
                if (graph[i][j] != 1) continue;
                boolean withZero = false;
                for(int k=0;k<dy.length;k++) {
                    int newY = i + dy[k];
                    int newX = j + dx[k];
                    if (newY < 0 || newY >= graph.length || newX < 0 || newX >= graph[0].length) {
                        withZero = true;
                        break;
                    }
                    if (graph[newY][newX] == 0) {
                        withZero = true;
                        break;
                    }
                }
                if (!withZero) {
                    graph[i][j] = 2;
                }
            }
        }
        return bfs(graph, characterY * 2, characterX * 2, itemY * 2, itemX * 2) / 2;
    }
    
    private int bfs(int[][] graph, int startY, int startX, int targetY, int targetX) {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Queue<Node> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[graph.length][graph[0].length];
        isVisited[startY][startX] = true;
        q.add(new Node(startY, startX, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            if (now.y == targetY && now.x == targetX) {
                return now.depth;
            }
            for(int k=0;k<4;k++) {
                int newY = now.y + dy[k];
                int newX = now.x + dx[k];
                if (newY < 0 || newY >= graph.length || newX < 0 || newX >= graph[0].length || isVisited[newY][newX] || graph[newY][newX] != 1) {
                    continue;
                }
                q.add(new Node(newY, newX, now.depth + 1));
                isVisited[newY][newX] = true;
            }
        }
        return -1;
    }
    
    private static class Node {
        int y;
        int x;
        int depth;
        
        Node(int y,int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}