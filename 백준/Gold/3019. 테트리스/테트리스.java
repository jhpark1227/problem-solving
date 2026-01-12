import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    private static int[][][] shapes = {
            {{0}, {0, 0, 0, 0}},
            {{0, 0}},
            {{0, 0, 1}, {1, 0}},
            {{1, 0, 0}, {0, 1}},
            {{0, 0, 0}, {0, 1}, {1, 0, 1}, {1, 0}},
            {{0, 0, 0}, {0, 0}, {0, 1, 1}, {2, 0}},
            {{0, 0, 0}, {0, 0}, {1, 1, 0}, {0, 2}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken()) - 1;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] heights = new int[c];
        for (int i = 0; i < c; i++) {
            heights[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int count = 0;
        for (int i = 0; i < shapes[p].length; i++) {
            int[] spaces = shapes[p][i];
            for (int j = 0; j + spaces.length <= c; j++) {
                boolean isSame = true;
                for (int k = j + 1; k < j + spaces.length; k++) {
                    if (heights[k] - spaces[k - j] != heights[k - 1] - spaces[k - (j + 1)]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static class Block {
        List<Position> positions;

        private Block(List<Position> positions) {
            this.positions = positions;
        }
    }

    private static class Position {
        int dy;
        int dx;

        private Position(int dy, int dx) {
            this.dy = dy;
            this.dx = dx;
        }
    }
}