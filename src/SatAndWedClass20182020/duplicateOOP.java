package SatAndWedClass20182020;

import java.util.ArrayList;

public class duplicateOOP {
    /*
    a sorted integer array without duplicates, return the continuous range.
Example 1:
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
     */

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,4,5,7};
        boolean isGood = true;
        ArrayList<String> arr2 = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            String empty = "";
            if(!isGood) {

            }
            if(arr[i + 1] == arr[i] + 1) {
                isGood = false;
                empty += arr[i]+"->";
                arr2.add(empty);
            }
        }
    }
}
