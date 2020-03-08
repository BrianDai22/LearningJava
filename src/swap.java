import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swap {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int length = Integer.parseInt(st.nextToken());
        int numSwaps = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        int aSwap = Integer.parseInt(st.nextToken()) - 1;
        int aSwap2 = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(f.readLine());
        int bSwap = Integer.parseInt(st.nextToken()) - 1;
        int bSwap2 = Integer.parseInt(st.nextToken()) - 1;

        int half = aSwap + ((aSwap2 + 1) - aSwap) / 2;
        int half2 = bSwap + ((bSwap2 + 1) - bSwap) / 2;

        int[] cows = new int[length];
        int[] cows2 = new int[length];
        int count = 1;
        for(int i = 0; i < length; i++) {
            cows[i] = count;
            cows2[i] = count;
            count++;
        }

        count = 0;

    for(int l = 0; l < numSwaps; l++) {
        int swapStart = aSwap;
        int swapEnd = aSwap2;
        for (int j = swapStart; j < half; j++) {
            int store = cows[j];
            cows[j] = cows[swapEnd];
            cows[swapEnd] = store;
            swapEnd--;
        }

        if(checker(cows,cows2)) {
            break;
        } else {
            count++;
        }


        swapStart = bSwap;
        swapEnd = bSwap2;
        for (int j = swapStart; j < half2; j++) {
            int store = cows[j];
            cows[j] = cows[swapEnd];
            cows[swapEnd] = store;
            swapEnd--;
        }

        if(checker(cows,cows2)) {
            break;
        } else {
            count++;
        }

    }

    numSwaps%=count;
        for(int l = 0; l < numSwaps; l++) {
            int swapStart = aSwap;
            int swapEnd = aSwap2;
            for (int j = swapStart; j < half; j++) {
                int store = cows2[j];
                cows2[j] = cows2[swapEnd];
                cows2[swapEnd] = store;
                swapEnd--;
            }

            swapStart = bSwap;
            swapEnd = bSwap2;
            for (int j = swapStart; j < half2; j++) {
                int store = cows2[j];
                cows2[j] = cows2[swapEnd];
                cows2[swapEnd] = store;
                swapEnd--;
            }

        }

    for(int i = 0; i < length; i++) {
        out.println(cows2[i]);
    }

        out.close();
    }
    public static boolean checker(int[] cows, int[] cows2) {
        int count = 0;
        for(int i = 0; i < cows.length; i++) {
            if(cows[i] == cows2[i]) {
                count++;
            }
        }

        return count == cows.length;
    }
}
/*
* [0,1,2....6]  init state
*
* repteat 100 times --> need to remove from [0,1,2 ... 6] -> [0,1,2..6] (waste time from init state  -> init state)
*
* [1, 4, 5, 6...] final state
*
* // find out how many cycles from init state to init state under the swap
*
* 1. create init sorted array
* 2. have counter and loop swap
* 3. check if you are sorted, yes? keep counter, No? counter++,then keep swap
*
* k = k % cycle
*
* swap k times, return result
*
* */
