import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] prev = new int[100001];
        int depth = bfs(n, k, prev);
        System.out.println(depth);
        int count = depth;
        int tmp = k;
        Stack<Integer> stack = new Stack<>();
        stack.add(tmp);
        while (count > 0) {
            stack.add(prev[tmp]);
            tmp = prev[tmp];
            count--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop()).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static int bfs(int n, int k, int[] prev) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        boolean[] isVisited = new boolean[100001];
        isVisited[n] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.value == k) {
                return now.depth;
            }
            for (int nextValue : new int[]{now.value + 1, now.value - 1, now.value * 2}) {
                if (nextValue > 100000 || nextValue < 0 || isVisited[nextValue]) {
                    continue;
                }
                isVisited[nextValue] = true;
                Node next = new Node(nextValue, now.depth + 1);
                queue.add(next);
                prev[nextValue] = now.value;
            }
        }
        return -1;
    }

    private static class Node {
        int value;
        int depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}