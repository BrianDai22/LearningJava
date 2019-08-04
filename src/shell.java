import java.io.*;
import java.util.StringTokenizer;

/*
ID: mooprules1
LANG: JAVA
TASK: shell
*/


public class shell {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("shell.in"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int swaps = Integer.parseInt(br.readLine());

            int[] A = new int[100];
            int[] B = new int[100];
            int[] G = new int[100];

            for(int i = 0; i < swaps; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
                G[i] = Integer.parseInt(st.nextToken());
            }

            int initPosi = 1;
            int currentPosi = initPosi;
            int answer = 0;
            for(int i = 0; i < swaps; i++) {
                if (currentPosi == A[i]) {
                    currentPosi = B[i];
                } else if (currentPosi == B[i]) {
                    currentPosi = A[i];
                }
                if (currentPosi == G[i]) {
                    answer++;

                }
            }
            pw.println(answer);
            pw.close();
        }
    }

