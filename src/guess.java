import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class guess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("guess.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
        int n = Integer.parseInt(br.readLine());
        String[][] animals = new String[n][100];
        int numCharacteristic = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            numCharacteristic = Integer.parseInt(st.nextToken());
            for (int j = 0; j < numCharacteristic; j++) {
                animals[i][j] = st.nextToken();
            }
        }
        for (int i = 0; i < animals.length; i++) {
            System.out.println(Arrays.deepToString(animals[i]));
        }
    }

    public static int overlap(String[] arr1, String[] arr2) {
        int count = 0;

        for (int i = 0; i < arr1.length && arr1[i] != null; i++) {
            for (int j = 0; j < arr2.length && arr2[j] != null; j++) {
                if (arr1[i].equals(arr2[j])) {
                    count++;
                }

            }
        }
        return count;

    }
}
