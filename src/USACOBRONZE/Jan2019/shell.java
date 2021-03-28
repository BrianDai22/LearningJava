package USACOBRONZE.Jan2019;

import java.io.*;
import java.util.StringTokenizer;

/*
ID: mooprules1
LANG: JAVA
TASK: USACO.Jan2019.shell
*/


public class shell {
    static int swaps;
    static int[] A = new int[100];
    static int[] B = new int[100];
    static int[] G = new int[100];

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("USACO.Jan2019.shell.in"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Jan2019.shell.out")));

            swaps = Integer.parseInt(br.readLine());

            for (int i = 0; i < swaps; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
                G[i] = Integer.parseInt(st.nextToken());
            }

            int finalAnswer = 0;
            for(int i = 1; i <= 3; i++) {
                finalAnswer = Math.max(answer(i), finalAnswer);
            }

            pw.println(finalAnswer);
            pw.close();
        }

        private static int answer(int initPosi) {
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
            return answer;
        }
    }

