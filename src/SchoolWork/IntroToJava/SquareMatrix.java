package SchoolWork.IntroToJava;
//class to store methods of SquareMatrix
public class SquareMatrix {
    //initialize matrixArray since not allowed to do so in driver
    public int[][] matrixArray;
    //initialize arraySize to make life easier
    public int arraySize;

    //add any integer to a specific spot in the matrix
    public void add(int i, int row, int column) {
        matrixArray[row][column] = i;
    }

    //checks for if all the values in the matrix are in between 1 and n * n inclusive
    public boolean allInRange() {
        //for loop to go through row
        for(int i = 0; i < arraySize; i++) {
            //for loop to go through column
            for(int j = 0; j < arraySize; j++) {
                //if the integer value is over n * n than it is not in range and return false
                if(matrixArray[i][j] > arraySize * arraySize) {
                    return false;
                }
            }
        }
        //return true if all in range
        return true;
    }

    //checks for if all the values in the matrix are unique
    public boolean allUnique() {
        //initialize boolean array to keep track of what integers has been seen so far
        boolean[] isDuplicate = new boolean[arraySize * arraySize + 1];
        //for loop to go through row
        for(int i = 0; i < arraySize; i++) {
            //for loop to go through column
            for(int j = 0; j < arraySize; j++) {
                //if this returns true that means the integer has been seen before so return false and the matrix is not all unique
                //also if this is greater than the boolean array size than return false because it will cause in out of boundary error
                if (matrixArray[i][j] < 1 || matrixArray[i][j] > arraySize || isDuplicate[matrixArray[i][j]]) {
                    return false;
                }
                //mark off the integer you see in the boolean array to check with other integers in the matrix
                isDuplicate[matrixArray[i][j]] = true;
            }
        }
        //return true if all numbers are unique
        return true;
    }

    //checks if the matrix is magical
    public boolean isMagic() {
        //if numbers are not all in range
        if(!allInRange()) {
            return false;
        }
        //if numbers are not all unique
        if(!allUnique()) {
            return false;
        }
        //initialize prime diagonal sum variable
        int diagonalSum = 0;
        //initialize secondary diagonal sum variable
        int secondaryDiagonalSum = 0;
        //for loop to calculate the prime diagonal sum and save it into the variable
        for (int i = 0; i < arraySize; i++) {
            diagonalSum = diagonalSum + matrixArray[i][i];
        }
        //for loop to calculate the secondary diagonal sum and save it into the variable
        for (int i = 0; i < arraySize; i++) {
            secondaryDiagonalSum = secondaryDiagonalSum + matrixArray[i][arraySize - 1 - i];
        }
        //if the diagonals are not equal to each other than matrix is not magical
        if(diagonalSum != secondaryDiagonalSum) {
            return false;
        }
        //for loop to go through row
        for (int i = 0; i < arraySize; i++) {
            //initialize variable to hold the value of each row and reset after each one
            int rowSum = 0;
            //for loop to go through column
            for (int j = 0; j < arraySize; j++) {
                //add values of the row into the variable
                rowSum += matrixArray[i][j];
            }
            //if any of the sums of the row does not equal the prime diagonal sum than the matrix is not magical
            if (rowSum != diagonalSum)
                return false;
        }
        //for loop to go through row
        for (int i = 0; i < arraySize; i++) {
            //initialize variable to hold the value of each column and reset after each one
            int columnSum = 0;
            //for loop to go through column
            for (int j = 0; j < arraySize; j++) {
                //add values of the column into a variable
                columnSum += matrixArray[j][i];
            }
            //if any of the sums of the column does not equal the prime diagonal sum than the matrix is not magical
            if (diagonalSum != columnSum)
                return false;
        }
        //if every single one of these checks do not return false than return true which means the matrix is magical
        return true;
    }

    //get matrixArray to print in the main driver
    public int[][] getMatrixArray() {
        //return matrixArray
        return matrixArray;
    }
}
