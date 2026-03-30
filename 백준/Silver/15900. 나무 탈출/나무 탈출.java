import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        System.out.println(findLeaf(graph, 1) % 2 != 0 ? "Yes" : "No");
    }

    private static int findLeaf(List<Integer>[] graph, int root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        boolean[] isVisited = new boolean[graph.length];
        isVisited[root] = true;
        int sum = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            boolean isLeaf = true;
            for (int next : graph[now.index]) {
                if (isVisited[next]) {
                    continue;
                }
                queue.add(new Node(next, now.depth + 1));
                isVisited[next] = true;
                isLeaf = false;
            }
            if (isLeaf) {
                sum += now.depth;
            }
        }
        return sum;
    }

    private static class Node {
        int index;
        int depth;

        public Node(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
}