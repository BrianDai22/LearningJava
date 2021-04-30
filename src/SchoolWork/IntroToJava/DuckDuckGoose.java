package SchoolWork.IntroToJava;
//SchoolWork.IntroToJava.DuckDuckGoose.java
//Author: Brian Dai
//Simulates a game like Duck Duck Goose

//imports to be able to use Java objects and APIs
import javax.swing.JOptionPane;
import java.util.Arrays;

//initialize public class to hold and run all methods written inside
public class DuckDuckGoose {
    //initialize main method to run other methods and obtain user inputs
    public static void main(String[] args) {
        //initialize variables to hold user inputs
        int confirmation = JOptionPane.YES_OPTION;
        int participants;
        int cycle;
        //Try again loop
        while (confirmation == JOptionPane.YES_OPTION) {
            //ask user for participant amount and hold the value in the participants variable
            participants = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of participants."));
            //ask user for cycle amount and hold value in the cycle variable
            cycle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of cycles."));
            //initialize boolean array with the size of participants
            boolean[] array = new boolean[participants];
            //print out the winner of the duck duck goose match
            JOptionPane.showMessageDialog(null, "Winner is " + playGame(array, cycle));
            //ask user if they want to continue and hold the value in the confirmation variable
            confirmation = JOptionPane.showConfirmDialog(null, "Do you want to try again?", null, JOptionPane.YES_NO_OPTION);
        }
    }

    //eliminates player
    public static int playGame(boolean[] array, int cycle) {
        //initialize variables
        int count = 1;
        int i = 0;
        //initialize array indexes with players by filling every array index with true
        Arrays.fill(array, true);
        //loop through array, if eliminated set to false, winner equals true, 0 equals false, anything greater than 1 equals true
        while (!findWinner(array)) {
            //update the value of the index
            i++;
            //if index reaches array length go back to zero
            if (i == array.length) {
                i = 0;
            }
            //if count equal to cycle and array is true, set that value to false
            if (count == cycle && array[i]) {
                array[i] = false;
                count = 1;
            }
            //don't count eliminated person
            if (array[i]) {
                count++;
            }
        }
        //return findWinnerPosition with array as its intake - 1 because Java starts counting from 0
        return findWinnerPosition(array) - 1;
    }

    //Finds the winner
    public static boolean findWinner(boolean[] array) {
        //initialize variables
        int numOfSurvivors = 0;
        //loop through array and count the people still in the game,
        //if value is greater than 1, then return false to continue the game,
        //otherwise return true to stop the game as the winner is found
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                numOfSurvivors++;
            }
            if (numOfSurvivors > 1) {
                return false;
            }
        }
        //return true if there is only one person survived in the array
        return true;
    }

    //Finds the winner's position
    public static int findWinnerPosition(boolean[] array) {
        //initialize variables
        int winnerLocation = -1;
        //loop through array and return the person that equals true
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                return i;
            }
        }
        //return -1 if no winner is found(never should happen)
        return winnerLocation;
    }
}
