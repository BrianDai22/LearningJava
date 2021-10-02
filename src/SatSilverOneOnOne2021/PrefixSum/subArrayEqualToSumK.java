package SatSilverOneOnOne2021.PrefixSum;

public class subArrayEqualToSumK {
    public static void main(String[] args) {
        int k = 0;
        int[] nums = new int[]{0,0,0};
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
