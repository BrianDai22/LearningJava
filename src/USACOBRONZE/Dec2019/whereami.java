package USACOBRONZE.Dec2019;

import java.io.*;
import java.util.*;

/*
ID: braindia
LANG: JAVA
TASK: Problem 2. Where Am I?
*/

public class whereami {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2019.whereami.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2019.whereami.out")));
        int length = Integer.parseInt(f.readLine());
        String empty = f.readLine();
        /*
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();


        for (int i = 0; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (j <= i) {
                    continue;
                }
                    arr.add(empty.substring(i, j));
            }
        }

        //boolean trueOrFalse = false;
        for(String x: arr) {
           whereamI(x);
        }
        System.out.println(arr2);

         */

        out.println(whereamI(empty));
        out.close();

    }

    public static int whereamI(String input){
        int answer = 0;
        for(int guess = 1; guess <= input.length(); guess++) {
            boolean isGood = true;
            for (int i = 0; i + guess <= input.length(); i++) {
                for (int j = 0; j < i; j++) { // j+USACO.Jan2019.guess != i+USACO.Jan2019.guess
                    if(input.substring(i, i + guess).equals(input.substring(j, j + guess))) {
                        isGood = false;
                    }
                }
            }
            if(isGood) {
                answer = guess;
                break;
            }
        }
        return answer;
    }
}

        /*
        String empty2 = empty;

        int index = 1;
        String temp = "";
        String temp2 = "";


        for(int i = 0; i < length; i++) {
            temp = empty.substring(0,index);
            empty = empty.replaceFirst(temp,"");
            if(empty.contains(temp)) {
                index++;
                empty = empty2;
            } else {
                break;
            }
        }

         */


/*
        for(int j = 0; j < length; j++) {
            temp2 = empty.substring(j,index);
            empty = empty.replace(temp2,"");
            for(int i = 0; i < length; i++) {
                if(!empty.contains(temp2)) {
                    out.println(temp2.length());
                    out.close();
                    break;
                } else {
                    index++;
                }
            }
            empty = empty2;
        }

 */



 /*
        String temp = "";
        int index = 1;

        for(int i = 0; i < length; i++) {
            temp = empty.substring(0,index);
            //System.out.println(temp);
            empty = empty.replaceFirst(temp,"");
            if(empty.contains(temp)) {
                index++;
                empty = empty2;
            } else {
                break;
            }
        }
        out.println(temp.length());
        out.close();

         */
