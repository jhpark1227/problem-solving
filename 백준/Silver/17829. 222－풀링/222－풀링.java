import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        while (true) {
            int[][] newMatrix = new int[matrix.length / 2][matrix.length / 2];
            for (int i = 0; i < newMatrix.length; i++) {
                for (int j = 0; j < newMatrix.length; j++) {
                    List<Integer> list = new ArrayList<>();
                    list.add(matrix[i * 2][j * 2]);
                    list.add(matrix[i * 2 + 1][j * 2]);
                    list.add(matrix[i * 2][j * 2 + 1]);
                    list.add(matrix[i * 2 + 1][j * 2 + 1]);
                    list.sort(Comparator.reverseOrder());
                    newMatrix[i][j] = list.get(1);
                }
            }
            matrix = newMatrix;
            if (matrix.length == 1) {
                break;
            }
        }
        System.out.println(matrix[0][0]);
    }
}