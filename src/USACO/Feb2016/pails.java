package USACO.Feb2016;

import java.io.*;
import java.util.StringTokenizer;

public class pails {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2016.pails.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2016.pails.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int smallPail = Integer.parseInt(st.nextToken());
        int bigPail = Integer.parseInt(st.nextToken());
        int mediumPail = Integer.parseInt(st.nextToken());
        int answer = 0;

        /*
        for(int i = 0; i*smallPail <= mediumPail; i++) {
            for(int j = 0; j*bigPail + i*smallPail <= mediumPail; j++) {
                answer = Math.max(answer, (j*bigPail + i*smallPail));
            }
        }

         */

        for(int i = 0; i * smallPail <= mediumPail; i++) {
            for(int j = 0; i*smallPail + j * bigPail <= mediumPail; j++) {
                answer = Math.max(answer, (i*smallPail+j*bigPail));
            }
        }


        /*
        int mediumPail2 = mediumPail;
        int temp = 0;
        int temp6 = mediumPail;
        int temp7 = 0;
        int answer = 0;
        int answer2 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp5 = 0;
        int temp4 = 0;

        temp2 = mediumPail % smallPail;
        temp2 = mediumPail - temp2;


        temp3 = mediumPail % bigPail;
        temp3 = mediumPail - temp3;


        temp5 = mediumPail % bigPail;
        temp5 = temp5 % smallPail;
        temp5 = mediumPail - temp5;

        temp4 = mediumPail % smallPail;
        temp4 = temp4 % bigPail;
        temp4 = mediumPail - temp4;


        for (int i = 0; i < 1000; i++) {
            if (mediumPail - bigPail < 0) {
                continue;
            } else {
                mediumPail = mediumPail - bigPail;
            }
                for (int j = 0; j < 1000; j++) {
                    if(mediumPail % smallPail < 0) {
                        break;
                    } else {
                        mediumPail = mediumPail % smallPail;
                    }
                    if(temp - mediumPail < 0) {
                        break;
                    } else {
                        temp = temp - mediumPail;
                    }

                    answer = Math.max(answer, temp);
                }
            }


        for (int i = 0; i < 1000; i++) {
            if (temp6 - smallPail < 0) {
                continue;
            } else {
                temp6 = temp6 - smallPail;
            }
            for (int j = 0; j < 1000; j++) {
                if(temp6 % bigPail < 0) {
                    break;
                } else {
                    temp6 = temp6 % bigPail;
                }
                if(temp7 - temp6 < 0) {
                    break;
                } else {
                    temp7 = temp7 - temp6;
                }
                answer2 = Math.max(answer2, temp7);
            }
        }


            answer = Math.max(answer, temp5);
            answer = Math.max(answer, temp3);
            answer = Math.max(answer, temp2);
            answer = Math.max(answer, temp4);
            answer = Math.max(answer, answer2);
         */




        out.println(answer);
        out.close();

        }
    }
