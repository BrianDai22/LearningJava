import java.util.Arrays;

public class twoDArrayToOneDArray {
        public static void main(String[] args) {
            char[][] grid = {
                    {'1','2','3','4','5'},
                    {'6','7','8','9','0'},
                    {'9','8','7','6','5'},
                    {'3','4','2','1','0'}
            };

            int m = grid.length;
            int n = grid[0].length;
            char[] flatGrid = new char[m*n];
            // convert to 1D array by only using i and j
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    flatGrid[i * grid[0].length + j] = grid[i][j];
                }
            }

            System.out.println(Arrays.toString(flatGrid));
        }
    }

