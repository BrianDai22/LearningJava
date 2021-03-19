package SatAndWedClass20182020;

import java.io.*;
import java.util.StringTokenizer;

public class square {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("SatAndWedClass20182020.square.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("SatAndWedClass20182020.square.out")));

        int answer;

        int temp;
        int temp1;
        int temp2;
        int temp3;
        int temp4;
        int temp5;

        int temp6;

        int ytemp;
        int ytemp1;
        int ytemp2;
        int ytemp3;
        int ytemp4;
        int ytemp5;

        int ytemp6;




        StringTokenizer st = new StringTokenizer(f.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(f.readLine());

        int x12 = Integer.parseInt(st2.nextToken());
        int y12 = Integer.parseInt(st2.nextToken());
        int x22 = Integer.parseInt(st2.nextToken());
        int y22 = Integer.parseInt(st2.nextToken());


        temp = Math.abs(x1-x2);
        temp1 = Math.abs(x1-x12);

        temp2 = Math.abs(x1-x22);
        temp3 = Math.abs(x2-x12);
        temp4 = Math.abs(x2-x22);

        temp5= Math.abs(x12-x22);

        temp6 = Math.max(temp,temp1);
        temp6 = Math.max(temp6,temp2);
        temp6 = Math.max(temp6,temp3);
        temp6 = Math.max(temp6,temp4);
        temp6 = Math.max(temp6,temp5);

        //-----------------------

        ytemp = Math.abs(y1-y2);
        ytemp1 = Math.abs(y1-y12);

        ytemp2 = Math.abs(y1-y22);
        ytemp3 = Math.abs(y2-y12);
        ytemp4 = Math.abs(y2-y22);

        ytemp5= Math.abs(y12-y22);

        ytemp6 = Math.max(ytemp,ytemp1);
        ytemp6 = Math.max(ytemp6,ytemp2);
        ytemp6 = Math.max(ytemp6,ytemp3);
        ytemp6 = Math.max(ytemp6,ytemp4);
        ytemp6 = Math.max(ytemp6,ytemp5);


        answer = Math.max(temp6, ytemp6);
        answer = answer * answer;

        System.out.println(temp6+" "+ ytemp6);
        System.out.println(answer);

        out.println(answer);
        out.close();


    }
}
