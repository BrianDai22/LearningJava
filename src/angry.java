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
        System.out.println(Arrays.toString(numberLine));

        int amountOfTouched = 0;
        for(int i = 0; i < numHay; i++) {
            System.out.println("index: "+i);
            int maxLeft = explosiveLeft(numberLine, i);
            System.out.println("maxlefr: "+maxLeft);
            int maxRight = explosiveRight(numberLine, i);
            System.out.println("maxright: "+maxRight);

            if(maxLeft + maxRight > amountOfTouched) {
                answer = i;
                amountOfTouched = maxLeft + maxRight;
            }

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


    public static int explosiveRight(int[] arr, int start) {
        int lastPosi = start;
        int explosionRangeRight= 1;


        for (int j = start; j <= arr.length-1;) {
            if ( j == arr.length -1) {
                return j - start + 1;
            }
            int nextPosi = j;
            boolean touched = false;
            for(int goSteps = 1 ; j + goSteps < arr.length - 1;) {
                if (arr[start + goSteps] <= arr[start] + explosionRangeRight) {
                    nextPosi = j + goSteps;
                    goSteps++;
                    touched = true;
                } else {
                    break;
                }
            }

            if(touched) {
                j = nextPosi;
                explosionRangeRight++;
            } else {
                lastPosi = j;
                break;

            }

        }
        return  lastPosi - start + 1;
    }

    public static int explosiveLeft(int[] arr, int start) {
        int lastPosi = start;
        int explosionRangeRight= -1;


        for (int j = start; j >= 0;) {
            if ( j == 0) {
                return start - j + 1;
            }
            int nextPosi = j;
            boolean touched = false;
            for(int goSteps = -1 ; j + goSteps >= 0;) {
                if (arr[start + goSteps] >= arr[start] + explosionRangeRight) {
                    nextPosi = j + goSteps;
                    goSteps--;
                    touched = true;
                } else {
                    break;
                }
            }

            if(touched) {
                j = nextPosi;
                explosionRangeRight--;
            } else {
                lastPosi = j;
                break;

            }

        }
        return  start - lastPosi + 1;
    }


}




/*

for(int i = 0; i * x <= m; i++) {
for(int j = 0; i*x + j * y <= m; j++) {
answer = Math.max(answer, (i*x+j*y));
}
}

 */