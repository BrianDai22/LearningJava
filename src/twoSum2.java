import java.util.Arrays;

public class twoSum2 {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ans = new int[2];

        /*
        boolean isGood = false;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    isGood = true;
                    break;
                }
            }
            if(isGood) {
                break;
            }
        }

         */

        int l = 0;
        int r = arr.length - 1;
        while (arr[l] + arr[r] != target) {
            if (arr[l] + arr[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        ans[0] = l + 1;
        ans[1] = r + 1;

        //2, 7, 11, 15
        System.out.println(Arrays.toString(ans));
    }
}

        //System.out.println(Arrays.toString(ans));
