import java.util.Arrays;

public class testing1234 {
    public static void main(String[] args) {
        int[][] queries = new int[][]{{1, 2, 100},{2, 5, 100},{3, 4 ,100}};
        int n = 5;
        int m = queries.length;
        int[] answer = new int[n];
        long answer2 = 0;

        for (int i = 0; i < m; i++) {
            for (int j = queries[i][0]-1; j < queries[i][1]; j++) {
                answer[j] += queries[i][2];
                answer2 = Math.max(answer2, answer[i]);
            }
        }

    }
}
