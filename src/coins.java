public class coins {
    /*
    You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
    Example 1:
    Input: coins = [1, 2, 5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:
    Input: coins = [2], amount = 3
    Output: -1
    Note:
    You may assume that you have an infinite number of each kind of coin.
     */

    public static int solver(int[] coins, int amount) {
        int count = 0;
        int answer = 0;
        int temp = 0;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] > amount) {
                temp++;
            }
        }
        if(temp == coins.length) {
            return -1;
        }
        temp = 0;
        while (count != amount) {
            for(int i = coins.length-1; i >= 0; i--) {
                if(coins[i] <= amount - count) {
                    count += coins[i];
                    answer++;
                    break;
                }
                temp++;
            }
            if(temp == coins.length) {
                return -1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] coins = new int[]{3,5};
        int amount = 4;
        System.out.println(solver(coins, amount));
    }
}
