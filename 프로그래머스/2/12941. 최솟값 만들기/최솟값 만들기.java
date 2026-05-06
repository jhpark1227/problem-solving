import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        int size = A.length;
        for(int i = 0; i < size; i++){
            sum += A[i] * B[size - i - 1];
        }
        return sum;
    }
}