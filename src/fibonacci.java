import java.util.ArrayList;

public class fibonacci {
    public static void main(String[] args) {
        //1,1,2,3,5,8,13
        System.out.println(fibonacciRecursive(4));
    }

    public static int fibonacciRecursive(int n) {
        //base case
        if (n <= 2) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Fibonacci Series using Dynamic Programming
    public static int fibonacciDP(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int[] f = new int[n + 2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i - 1] + f[i - 2];//state transfer function
        }

        return f[n];
    }
}
