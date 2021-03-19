package SatAndWedClass20182020;

import java.util.ArrayList;
import java.util.Arrays;

public class duplicatev3 {
    // write a method called "removeDupFromArray" to remove duplicate element in sorted array (only use array)
    // parameter : String [], only contain lowercase string
    // return: String []
    // TODO

    public static String[] removeDupFromArray(String[] arr2) {

        int emptyIndex = 0;

        /*
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[i].equals(arr2[j])) {
                    arr2[j] = "";
                    for (int k = j + 1; k < arr2.length; k++) {
                        arr2[k - 1] = arr2[k];
                        if (k == arr2.length - 1) {
                            arr2[k] = "";
                        }
                    }
                }
            }
        }

        for(int i = 0; i < arr2.length; i++) {
            if(arr2[i].equals("")) {
                emptyIndex = i;
                break;
            }
        }

        return Arrays.copyOfRange(arr2,0, emptyIndex);

         */

        for(int i = 1; i < arr2.length; i++) {
            if(!arr2[i].equals(arr2[emptyIndex])) {
                emptyIndex++;
                arr2[emptyIndex] = arr2[i];
            }
        }

        return Arrays.copyOfRange(arr2,0,emptyIndex+1);

    }

    // write a method called "removeDupFromArrayList" to remove duplicate element in sorted arraylist (only use arraylist)
    // parameter : ArrayList<String>,  only contain lowercase string
    // return: ArrayList<String>
    // TODO

    public static ArrayList<String> removeDupFromArrayList(ArrayList<String> arr3) {

        for (int i = 0; i < arr3.size(); i++) {
            for (int j = i + 1; j < arr3.size(); j++) {
                if (arr3.get(i).equals(arr3.get(j))) {
                    arr3.remove(j);
                }
            }
        }
        return arr3;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "a", "b", "c", "c", "d"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(Arrays.toString(removeDupFromArray(arr)));
        System.out.println(removeDupFromArrayList(list));
    }
}

/*
Example
input = ["a", "a", "b", "c", "c", "d"]
output = ["a", "b", "c", "d"]
*/
