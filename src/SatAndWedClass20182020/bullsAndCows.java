package SatAndWedClass20182020;

public class bullsAndCows {
    /*
    You are playing the following Bulls and Cows game with your friend:
    You write down a number and ask your friend to USACO.Jan2019.guess what the number is.
    Each time your friend makes a USACO.Jan2019.guess,
    you provide a hint that indicates how many digits in said USACO.Jan2019.guess match your secret number exactly in both digit and position
    (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
    Your friend will use successive guesses and hints to eventually derive the secret number.
Write a function to return a hint according to the secret number and friend's USACO.Jan2019.guess, use A to indicate the bulls and
B to indicate the cows.
Please note that both secret number and friend's USACO.Jan2019.guess may contain duplicate digits.
Example 1:
Input: secret = "1807", USACO.Jan2019.guess = "7810"
Output: "1A3B"
Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:
Input: secret = "1123", USACO.Jan2019.guess = "0111"
secret = "123", USACO.Jan2019.guess = "011"
a[1] = 0, a[2] = 1, a[3] = 1;
b[1] = 1, b[2] = 0, b[3] = 0;
Output: "1A1B"
Explanation: The 1st 1 in friend's USACO.Jan2019.guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's
     */
    public String bullncows(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int len = secret.length();
        int[] a = new int[10];
        int[] b = new int[10];

        for(int i = 0; i < len; i++){
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
            } else {
                int num1 = secret.charAt(i) - '0';
                int num2 = guess.charAt(i) - '0';
                a[num1]++;
                b[num2]++;
            }
        }
        for(int i = 0;i < 10 ; i++){
            cows += Math.min(a[i], b[i]);
        }
        return (String.valueOf(bulls)+ 'A'+ cows +'B');
    }
}
