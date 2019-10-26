import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class balancing {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cows = Integer.parseInt(st.nextToken());
        //int B = Integer.parseInt(st.nextToken());
        int[] x = new int[cows];
        int[] y = new int[cows];
        //int[] graph = new int[B + 1];
        //int[] graph2 = new int[B / 2];
        int answer = cows;


        for (int i = 0; i < cows; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st2.nextToken());
            y[i] = Integer.parseInt(st2.nextToken());
        }

        /*
        int count = 0;
        for (int i = 1; i < B + 1; i++) {
            if (i % 2 == 0) {
                graph[count] = i;
                count++;
            }
        }

        for (int i = 0; i < B / 2; i++) {
            if (graph[i] != 0) {
                graph2[i] = graph[i];
            }
        }
        */



        for (int i = 0; i < cows; i++) {
            for (int k = 0; k < cows; k++) {
                int xFence = x[i] + 1;
                int yFence = y[k] + 1;
                int count = 0;
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
                for (int j = 0; j < cows; j++) {
                    if (y[j] < yFence && x[j] < xFence) {
                        count++;
                    } else if (y[j] < yFence && x[j] > xFence) {
                        count2++;
                    } else if (y[j] > yFence && x[j] < xFence) {
                        count3++;
                    } else if (y[j] > yFence && x[j] > xFence) {
                        count4++;
                    }

                    System.out.println("Y = " + y[j] + " " + " X = " + x[j] + " " + "With X-Axis: " + xFence + " With Y-Axis: " + yFence);

                }

                System.out.println(count + " " + count2 + " " + count3 + " " + count4);

                int maxCows = 0;
                if (count2 > maxCows) {
                    maxCows = count2;
                }
                if (count4 > maxCows) {
                    maxCows = count4;
                }
                if (count > maxCows) {
                    maxCows = count;
                }
                if (count3 > maxCows) {
                    maxCows = count3;
                }

                if (maxCows < answer) {
                    answer = maxCows;
                }
            }
        }

            out.println(answer);
            out.close();
        }
    }

    /*
        int[] freq = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 4; j++) {
                for (int k = j; k < 4; k++) {
                    for (int g = k; g < 4; g++) {
                        if (i + j + k + g == cows) {
                            freq[0] = i;
                            freq[1] = j;
                            freq[2] = k;
                            freq[3] = g;
                            break;
                        }
                    }
                }
            }
        }

         */