package SatSilverOneOnOne2021.TwoPointer;

import java.util.Arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,12};
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
