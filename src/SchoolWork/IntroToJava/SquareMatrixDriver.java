package SchoolWork.IntroToJava;

//import to use JOptionPane
import javax.swing.*;
//import to use Arrays API
import java.util.Arrays;

//class to hold main of SquareMatrixDriver
public class SquareMatrixDriver {
    //class to ask and hold user-inputted values
    public static void main(String[] args) {
        //holds the choice of the user if they want to continue the program
        int userChoice = JOptionPane.YES_OPTION;
        //call the SquareMatrix file
        SquareMatrix scan = new SquareMatrix();
        //if the user selects yes than run the loop
        while (userChoice == JOptionPane.YES_OPTION) {
            //asks and stores user-inputted array size
            int arraySize = Integer.parseInt(JOptionPane.showInputDialog(null, "Input the size of the matrix"));
            //initializes matrixArray from the SquareMatrix file
            scan.matrixArray = new int[arraySize][arraySize];
            //initializes arraySize from the SquareMatrix file
            scan.arraySize = arraySize;
            //for loop to go through row
            for(int i = 0; i < arraySize; i++) {
                //for loop to go through column
                for(int j = 0; j < arraySize; j++) {
                    //ask user for integer at each coordinate in the matrix array and use the add method from the SquareMatrix file to put it in the slot
                    scan.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Input the value for (" + i + "," + j + ")")), i, j);
                }
            }
            //calls the isMagic method from the SquareMatrix file
            if(scan.isMagic()) {
                //if true than matrix is magical
                //print out user-inputted array
                JOptionPane.showMessageDialog(null, "Matrix is a Magic Square: " + Arrays.deepToString(scan.getMatrixArray()));
            } else {
                //if false than matrix is not magical
                //print out user-inputted array
                JOptionPane.showMessageDialog(null, "Matrix is not a Magic Square: " + Arrays.deepToString(scan.getMatrixArray()));
            }
            //ask user if they want to run the loop again to try different values
            userChoice = JOptionPane.showConfirmDialog(null, "Do you want to try again?", null, JOptionPane.YES_NO_OPTION);
        }
    }
}
