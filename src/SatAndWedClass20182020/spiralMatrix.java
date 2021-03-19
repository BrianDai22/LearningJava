package SatAndWedClass20182020;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public static List<Integer> spiralMatrixx(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0 ;
        int colEnd = matrix[0].length-1;


        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i < rowEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i < rowEnd; i++) {
                list.add(matrix[i][colEnd - 1]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd - 1; i >= 1; i--) {
                    list.add(matrix[rowEnd - 1][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd - 1; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return list;

    }




    public static void main(String[] args) {

    }
}


/*
public static List<Integer> SatAndWedClass20182020.spiralMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0 ;
        int colEnd = matrix[0].length-1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i < rowEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i < rowEnd; i++) {
                list.add(matrix[i][colEnd - 1]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd - 1; i >= 1; i--) {
                    list.add(matrix[rowEnd - 1][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd - 1; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return list;
    }
 */