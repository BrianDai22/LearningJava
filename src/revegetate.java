import java.io.*;
import java.util.StringTokenizer;

public class revegetate {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        int n = Integer.parseInt(f.readLine());
        int m = Integer.parseInt(f.readLine());

        int[] choice1 = new int[m+1];
        int[] choice2 = new int[m+1];
        int[] result = new int[m+1];
        for(int i = 1; i < m; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            choice1[i] = Integer.parseInt(st.nextToken());
            choice2[i] = Integer.parseInt(st.nextToken());

        }

        for(int i = 1; i < m + 1; i++) {
            boolean isOk = true;
            for(int grass = 1; grass< 5; grass++) {
                for(int k = 1; k < m + 1; k++) {
                    if(choice2[k] == i && result[choice1[k]] == grass) {
                        isOk = false;
                        break;
                    }

                }
                if(isOk) {
                    result[i] = grass;
                    break;
                }

            }

        }



    }
    /*
    private static int swap(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;

        }
        return a && b;
    }

     */
}

