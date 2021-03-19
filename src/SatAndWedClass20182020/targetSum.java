package SatAndWedClass20182020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class targetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, 0, S);
    }

    public static int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum < S || (sum-S)%2 != 0) {
            return 0;
        }
        int targetSum = (sum-S)/2;
        int[] dp = new int[targetSum+1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = targetSum-nums[i]; j >= 0; j--) {
                dp[j + nums[i]] += dp[j];
            }
            System.out.println("i: " + i + " nums[i]: " + nums[i] + " dp: " + Arrays.toString(dp));
        }
        return dp[targetSum];
    }

    public static int dfs(int[] nums, int sum, int i, int S) {
        if (i == nums.length) {
            if(sum == S) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(nums, sum + nums[i], i + 1, S) + dfs(nums, sum - nums[i], i + 1, S);
    }

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }
}