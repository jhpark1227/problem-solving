import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    private enum Zone {
        SAFE, DEATH, DANGER
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Zone[][] zones = new Zone[501][501];
        for (int i = 0; i < zones.length; i++) {
            Arrays.fill(zones[i], Zone.SAFE);
        }
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int minX = Math.min(x1, x2), maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2), maxY = Math.max(y1, y2);
            for (int j = minX; j <= maxX; j++) {
                for (int k = minY; k <= maxY; k++) {
                    zones[k][j] = Zone.DANGER;
                }
            }
        }
        int m = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            int minX = Math.min(x1, x2), maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2), maxY = Math.max(y1, y2);
            for (int j = minX; j <= maxX; j++) {
                for (int k = minY; k <= maxY; k++) {
                    zones[k][j] = Zone.DEATH;
                }
            }
        }
        System.out.print(bfs(zones));
    }

    private static int bfs(Zone[][] zones) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, 0, 0));
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        boolean[][] isVisited = new boolean[501][501];
        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();
            if (now.y == 500 && now.x == 500) {
                return now.depth;
            }
            for (int i = 0; i < dy.length; i++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if (newY < 0 || newX < 0 || newY > 500 || newX > 500 || isVisited[newY][newX]) {
                    continue;
                }
                if (zones[newY][newX] == Zone.DEATH) {
                    continue;
                }
                if (zones[newY][newX] == Zone.DANGER) {
                    deque.addLast(new Node(newY, newX, now.depth + 1));
                    isVisited[newY][newX] = true;
                } else {
                    deque.addFirst(new Node(newY, newX, now.depth));
                    isVisited[newY][newX] = true;
                }
            }
        }
        return -1;
    }

    private static class Node {
        int y;
        int x;
        int depth;

        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}