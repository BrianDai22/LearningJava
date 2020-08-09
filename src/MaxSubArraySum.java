import java.util.ArrayList;
import java.util.Arrays;

public class MaxSubArraySum {
    // reuturn the contiguous subarray which has the largest sum.
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

    public static int[] maxSubArray(int[] nums) {
        int answer = 0;
        int startIndex = 0;
        int endIndex = 0;
        int temp;

        for(int i = 0; i < nums.length; i++) {
            temp = 0;
            temp += nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if(temp > answer) {
                    answer = temp;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return Arrays.copyOfRange(nums, startIndex, endIndex+1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(maxSubArray(nums)));
    }
}
