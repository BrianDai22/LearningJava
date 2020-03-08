import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class diagonalMatrix {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int N = matrix.length;
        int M = matrix[0].length;

        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for(int d = 0; d < N + M - 1; d++) {
            intermediate.clear();

            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            while(r < N && c > -1) {
                intermediate.add(matrix[r][c]);
                r++;
                c--;

            }

            if(d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for(int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }

        return result;


    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int temp = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                matrix[i][j] = temp++;
            }
        }
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }
}
