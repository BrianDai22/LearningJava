import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st;
        st = new StringTokenizer(f.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        int[][] arrr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < columns; j++) {
                arrr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Arrays.deepToString(arrr));

        int[] arrr2 = arrr[0].clone();
        Arrays.sort(arrr2);


        //int[] interval = new int[columns];
        int lengthOfTrans = columns * columns;
        //int temp = 0;
        /*
        for(int i = columns; i > 0; i--) {
            lengthOfTrans+= i;
            //interval[temp] = i;
            //temp++;
        }
         */

        System.out.println(lengthOfTrans);
        //System.out.println(Arrays.toString(interval));

        int[][] transcript = new int[lengthOfTrans][2];
        int temp = 0;
        for(int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                transcript[temp][0] = i + 1;
                transcript[temp][1] = j + 1;

                System.out.println(i+j+"-"+transcript[i*j][0] + "-" + transcript[i*j][1]);
                temp++;
            }
        }

        /*
        temp = interval[0];
        int temp2 = 0;
        int temp3 = 1;
        for(int i = 0; i < columns; i++) {
            for(int j = temp2; j < temp; j++) {
                transcript[i][0] = ;
                transcript[i][1] = i+temp3;
            }
            temp2 += interval[i];
            temp += interval[i];
            temp3 = 1;
        }
         */


        System.out.println(Arrays.deepToString(transcript));

        /*
        temp = 2;
        for(int i = 0; i < interval[0]; i++) {
            transcript[i][0] = 1;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 3;
        for(int i = interval[0]; i < interval[1] + interval[0]; i++) {
            transcript[i][0] = 2;
            transcript[i][1] = temp;
            temp++;
        }

        temp = 4;
        for(int i = interval[1] + interval[0]; i < interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 3;
            transcript[i][1] = temp;
            temp++;
        }

        temp = 5;
        for(int i = interval[2] + interval[1] + interval[0]; i < interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 4;
            transcript[i][1] = temp;
            temp++;
        }

        temp = 6;
        for(int i = interval[3] + interval[2] + interval[1] + interval[0]; i < interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 5;
            transcript[i][1] = temp;
            temp++;
        }

        temp = 7;
        for(int i = interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 6;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 8;
        for(int i = interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 7;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 9;
        for(int i = interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 8;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 10;
        for(int i = interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 9;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 11;
        for(int i = interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 10;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 12;
        for(int i = interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 11;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 13;
        for(int i = interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 12;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 14;
        for(int i = interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 13;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 15;
        for(int i = interval[12]+interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[13] + interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 14;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 16;
        for(int i = interval[13] + interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[14] + interval[13]+ interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 15;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 17;
        for(int i = interval[14] + interval[13] + interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[15] + interval[14] + interval[13] + interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 16;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 18;
        for(int i = interval[15] + interval[14]+interval[13]+interval[12]+interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[16] + interval[15] + interval[14] + interval[13] + interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 17;
            transcript[i][1] = temp;
            temp++;
        }
        temp = 19;
        for(int i = interval[16] + interval[15] + interval[14] + interval[13] + interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i < interval[17] + interval[16] + interval[15] + interval[14] + interval[13] + interval[12] + interval[11] + interval[10] + interval[9] + interval[8] + interval[7] + interval[6] + interval[5] + interval[4] + interval[3] + interval[2] + interval[1] + interval[0]; i++) {
            transcript[i][0] = 18;
            transcript[i][1] = temp;
            temp++;
        }

        transcript[189][0]=19;
        transcript[189][1] = 20;

         */


        //System.out.println(Arrays.deepToString(transcript));

        //System.out.println(indexOf(arrr[0],1));

        int num1;
        int num2;
        int num1Index;
        int num2Index;
        int count = 0;
        int count2 = 0;
        for(int i = 0; i < lengthOfTrans; i++) {
            num1 = transcript[i][0];
            num2 = transcript[i][1];
            if(num1 > arrr2[arrr2.length-1]) {
                break;
            }
            if(num2 > arrr2[arrr2.length-1] || num1 >= num2) {
                continue;
            }
            for(int j = 0; j < rows; j++) {
                num1Index = indexOf(arrr[j],num1);
                //System.out.println(i +" : index1:"+num1Index);
                num2Index = indexOf(arrr[j],num2);
                //System.out.println(i +" : index2:"+num2Index);
                if(num1Index < num2Index) {
                    count2++;
                }
            }
            if(count2 == rows) {
                count++;
            }
            count2 = 0;
        }

        count2 = 0;

        for(int i = 0; i < lengthOfTrans; i++) {
            num1 = transcript[i][0];
            num2 = transcript[i][1];
            if(num1 > arrr2[arrr2.length-1]) {
                break;
            }
            if(num2 > arrr2[arrr2.length-1] || num1 >= num2) {
                continue;
            }
            for(int j = 0; j < rows; j++) {
                num1Index = indexOf(arrr[j],num1);
                num2Index = indexOf(arrr[j],num2);
                if(num2Index < num1Index) {
                    count2++;
                }
            }
            if(count2 == rows) {
                //System.out.println(num1 + " " + num2);
                count++;
            }
            count2 = 0;

        }



        //System.out.println(Arrays.deepToString(transcript));
        //System.out.println(lengthOfTrans);
        // System.out.println(count);

        /*
        int index = 0;
        for(int h = 0; h < columns; h++) {
            int temp = arr2[index];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {

                }
            }
        }

         */








        out.println(count);
        out.close();

    }

    public static int indexOf(int[] arr, int a) {
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == a) {
                index = i;
                break;
            }
        }
        return index;
    }

}

/*
Arrays.sort(arr2);
        int lengthOfTrans = 0;

        for(int i = arr2[arr2.length-1]; i >= 0; i--) {
            if(i == 0) {
                break;
            }
            lengthOfTrans+= i;
        }

        int[][] transcript = new int[lengthOfTrans][2];

        int temp = 1;
        int temp2 = 0;
        for(int i = arr2[arr2.length-1]; i >= 0; i--) {
            if(i == 0) {
                break;
            }
            for(int j = 0; j < i; j++) {
                transcript[temp2][0] = temp;
                temp2++;
            }
            temp++;
        }


        for(int i = arr2[arr2.length-1]; i > 0; i--) {
            for(int j = i; j > 0; j--) {

                if(transcript[temp2][0] == temp && temp >= j) {
                    transcript[temp2][0] = 0;
                    transcript[temp2][1] = 0;
                    temp2++;
                    continue;
                }

                transcript[temp2][1] = j;
                temp2++;
            }
            temp++;
        }


        temp = 1;
        temp2 = 0;

        for(int i = 0; i < lengthOfTrans; i++) {
            for(int j = 0; j < arr2[arr2.length-1]; j++) {
                transcript[temp2][1] = j;
            }
        }


        int num1;
        int num2;
        int num1Index;
        int num2Index;
        int count = 0;
        int count2 = 0;
        for(int i = 0; i < lengthOfTrans; i++) {
            num1 = transcript[i][0];
            num2 = transcript[i][1];
            for(int j = 0; j < rows; j++) {
                num1Index = indexOf(arrr[j],num1);
                num2Index = indexOf(arrr[j],num2);
               if(num1Index < num2Index) {
                   count2++;
               }
            }
            if(count2 == rows) {
                count++;
            }
        }

        for(int i = 0; i < lengthOfTrans; i++) {
            num1 = transcript[i][0];
            num2 = transcript[i][1];
            for(int j = 0; j < rows; j++) {
                num1Index = indexOf(arrr[j],num1);
                num2Index = indexOf(arrr[j],num2);
                if(num2Index < num1Index) {
                    count2++;
                }
            }
            if(count2 == rows) {
                count++;
            }

        }



        System.out.println(Arrays.deepToString(transcript));
        System.out.println(lengthOfTrans);
       // System.out.println(count);

        /*
        int index = 0;
        for(int h = 0; h < columns; h++) {
            int temp = arr2[index];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {

                }
            }
        }

         */


