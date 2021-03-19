package SchoolWork.IntroToJava;/*
SchoolWork.INTRO.ArrayMethods.java
Author: Brian Dai
Enables a user to create their own array and choose to use one of three choices: reverse, smallestValue, and largestValue.
 */
//import scanner to use the scanner API
import java.util.Scanner;

//create class to hold all of the methods that are going to be used
public class ArrayMethods {
    //create main method to run the methods and ask/store user-inputs
    public static void main(String[] args) {
        //initialize scanner to be used later on
        Scanner in = new Scanner(System.in);
        //print out the three choices for methods
        System.out.println("1. SatAndWedClass20182020.Reverse an array\n" +
                "2. Smallest element of an array\n" +
                "3. Largest element of an array");
        //ask user for their choice for method they want to use
        System.out.println("Enter your choice: ");
        int choice = in.nextInt();
        //ask user for the size of the array
        System.out.println("Enter amount of elements in the array: ");
        int size = in.nextInt();
        //create an array with the user-inputted size
        int[] arr = new int[size];
        //create a string to hold values in the array
        String stringArr = "";
        //for each index in the array ask the user for a element to be put in the specific index while also adding into
        //the string array to be printed so the user can see
        for(int i = 0; i < arr.length; i++) {
            //ask user for element for the specific index
            System.out.println("Enter element: " + i);
            //store the user-inputted element
            int element = in.nextInt();
            //add element into string array to be printed later
            stringArr += element + " ";
            //store element into specific index of the array
            arr[i] = element;
        }
        //print out string array which holds every value in the array and trim the end so there is no extra space
        System.out.println("You entered: " + stringArr.trim());
        //yes or no holds the value that the user-inputted if they want to continue the while loop to use other methods
        int yesOrNo = 1;
        //while loop to run the methods down below and continues if user-inputs 1 and stops if user-inputs 2
        while(yesOrNo == 1) {
            //if the choice is 1 print out the reverse method
            if (choice == 1) {
                //make string array into empty string to be reused and not have left over data from last use
                stringArr = "";
                //loop to add values from the reversed array into string array to be printed
                for(int i = 0; i < arr.length; i++) {
                    //add values from reverse array into string array
                    stringArr += reverseArray(arr)[i] + " ";
                }
                //print out the string array with the reversed array trimming the end to get rid of extra space
                System.out.println("In reverse: " + stringArr.trim());
            //if choice is 2 then print out the smallest element in the array
            } else if (choice == 2) {
                //print out smallestValue method
                System.out.println("The smallest element is: " + smallestValue(arr));
            //if choice is not 1 or 2 then print out the largest element in the array
            } else {
                //print out largestValue method
                System.out.println("The largest element is: " + largestValue(arr));
            }
            //ask if user wants to use one of the methods again 1 for yes 2 for no
            System.out.println("Again? (1 for yes, 2 for no): ");
            //store user-inputted choice for wanting to continue
            yesOrNo = in.nextInt();
        }
    }
    //This method takes an integer array as a parameter and returns the array in reverse order.
    public static int[] reverseArray(int[] arr) {
        //loops through half the array and has two pointers. One starts from the first index and one starts
        //from the last index and they keep on swapping until they converge in the middle.
        for(int i = 0; i < arr.length / 2; i++) {
            //temporary variable to not lose data while swapping
            int temp = arr[i];
            //the first pointer value equals the second pointer value
            arr[i] = arr[arr.length - i - 1];
            //the second pointer value equals the first pointer value which is stored in temp
            arr[arr.length - i - 1] = temp;
        }
        //return reversed array
        return arr;
    }
    //This method takes an integer array as a parameter and returns the smallest value in the array.
    public static int smallestValue(int[] arr) {
        //variable to hold min value in the array and is initialized with maximum value because if starts with 0
        //then will always be equal to zero if all values are positive
        int minVal = Integer.MAX_VALUE;
        //loop through array and use Math.min to compare the current minimum with array values and update each loop if needed
        for(int i = 0; i < arr.length; i++) {
            //compare current minimum value with current index array value
            minVal = Math.min(minVal, arr[i]);
        }
        //return minimum value
        return minVal;
    }
    //This method takes an integer array as a parameter and returns the largest value in the array.
    public static int largestValue(int[] arr) {
        //variable to hold max value
        int maxVal = Integer.MIN_VALUE;
        //loop through array and use Math.max to compare the current max value with array values and update each loop if needed
        for(int i = 0; i < arr.length; i++) {
            //compare current max value with current index array value
            maxVal = Math.max(maxVal, arr[i]);
        }
        //return max value
        return maxVal;
    }
}
