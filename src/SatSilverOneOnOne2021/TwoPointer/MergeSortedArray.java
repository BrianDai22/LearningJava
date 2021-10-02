package SatSilverOneOnOne2021.TwoPointer;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        int b = n + m + 2;
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{2,5,6};
        int[] result = new int[b];
        while(p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] > arr2[p2]) {
                result[index] = arr2[p2];
                p2++;
            } else {
                result[index] = arr1[p1];
                p1++;
            }
            index++;
        }

        if(p1 < n) {
            for(int i = p1; i < arr1.length; i++) {
                result[index] = arr1[i];
                index++;
            }
        }
        if(p2 < m) {
            for(int i = p2; i < arr2.length; i++) {
                result[index] = arr2[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
