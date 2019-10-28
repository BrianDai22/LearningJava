import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class angry {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

        int numHay = Integer.parseInt(f.readLine());
        int[] numberLine = new int[numHay];
        int answer = 1;

        for (int i = 0; i < numHay; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            numberLine[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberLine);

        for(int i = 0; i < numHay; i++) {
            int maxLeft = explosiveLeft(numberLine, i);
            System.out.println("maxlefr: "+maxLeft);
            int maxRight = explosiveRight(numberLine, i);
            System.out.println("maxright: "+maxRight);

            int bestNum = maxRight - maxLeft;

            answer = Math.max(answer,bestNum);
        }


        out.println(answer);

        out.close();
        /*
        for (int i = 0; i < numHay; i++) {
            int count = 0;
            int index = 0;
            int explosionRangeLeft = 0;
            int explosionRangeRight = 0;
            for (int j = 1; j < numHay - 1; j++) {
                if (numberLine[j] - numberLine[i] == 1) {
                    count++;
                    explosionRangeLeft++;
                } else {
                    if (numberLine[j] - numberLine[i] <= explosionRangeLeft) {
                        count++;
                        explosionRangeLeft++;
                    }
                }
                if (numberLine[j] - numberLine[i + 1] == 1) {
                    count++;
                    explosionRangeRight++;
                } else {
                    if (numberLine[j] - numberLine[i + 1] <= explosionRangeRight) {
                        count++;
                        explosionRangeRight++;
                    }
                }

                answer = Math.max(count, answer);
            }
        }

         */

    }

    public static int explosiveLeft(int[] arr, int start) {
        int answer = 1;
        int index = start - 1;
        int count = 1;
        int explosionRangeLeft = 1;

        if(start == 0) {
            return count;
        }
            for (int j = start; j >= 0; j--) {
                if (arr[j] - arr[index] <= explosionRangeLeft && arr[j] - arr[index] >= 1) {
                    if(index - 1 >= 0) {
                        index--;
                    }
                    count++;
                    explosionRangeLeft++;
                }
                answer = Math.max(answer,count);
            }
        return count;
    }
    public static int explosiveRight(int[] arr, int start) {
        int answer = 1;
        int index = start + 1;
        int count = 1;
        int explosionRangeRight= 1;

        for (int j = start; j < arr.length-1; j++) {
            if (Math.abs(arr[j] - arr[index]) <= explosionRangeRight && Math.abs(arr[j] - arr[index]) >= 1) {
                index++;
                count++;
                explosionRangeRight++;
            }
            answer = Math.max(answer,count);
        }
        return count;
    }

}




/*

 */