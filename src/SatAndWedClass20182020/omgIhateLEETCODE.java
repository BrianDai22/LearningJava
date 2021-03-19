package SatAndWedClass20182020;

public class omgIhateLEETCODE {
        public static int minSubArrayLen(int s, int[] nums) {
            if(nums.length == 0) {
                return 0;
            }
            int answer = Integer.MAX_VALUE;
            for(int j = 0; j < nums.length; j++) {
                for (int i = j; i < nums.length; i++) {
                    //123456
                    //23456
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += nums[k];
                    }
                    if (sum >= s) {
                        answer = Math.min(answer, (j - i + 1));
                        break;
                    }
                }
            }

            System.out.println(answer);

            return answer == Integer.MAX_VALUE ? 0 : answer;
        }

    public static void main(String[] args) {
            int[] nums = new int[]{5,1,3};
            System.out.println(minSubArrayLen(15, nums));
    }
}

