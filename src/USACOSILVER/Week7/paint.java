package USACOSILVER.Week7;

import java.io.*;
import java.util.StringTokenizer;

public class paint {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week7.paint.in"));
    // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week7.paint.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int a =Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(f.readLine());

        int c =Integer.parseInt(st2.nextToken());
        int d = Integer.parseInt(st2.nextToken());

        /*
       int min = Math.min(a,c);

       int max = Math.max(b,d);


       int answer = Math.abs(max - min);

       boolean overlap;

        if(b < c && a < d) {
           overlap = false;
       } else {
            if(b > c && a > d) {
                overlap = false;
            } else {
                overlap = true;

            }
       }

        int count = b - a;
        int count2 = d - c;


         */

        int temp;

        if(c < a) {
            temp = a;
            a = c;
            c = temp;
            temp = b;
            b = d;
            d = temp;
        }

        if(c >= b) {
            out.println(d-c + b-a);
            out.close();
        } else {
            if(d > b) {
                out.println(d-a);
                out.close();
            } else {
                out.println(b-a);
                out.close();
            }
        }


        /*

        int[] arr2 = new int[b - a + 1];
        int[] arr = new int[d - c + 1];
        int temp = a;

        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = temp;
            temp++;
        }

        temp = c;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp;
            temp++;
        }

        Set<Integer> duplicates = new HashSet<>();

        for(int i = 0; i < arr2.length; i++) {
            duplicates.add(arr2[i]);
        }

        for(int i = 0; i < arr.length; i++) {
            duplicates.add(arr[i]);
        }

        if(duplicates.size() > arr.length + arr2.length || duplicates.size() < arr.length + arr2.length) {
            overlap = true;
        }

         */
        /*

        if(overlap) {
            out.println(answer);
            out.close();
        } else {
            out.println(count + count2);
            out.close();
        }

        */

        /*

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[0]) {
                continue;
            } else {
                if(arr[i] == arr[arr.length-1]) {
                    break;
                } else {
                    count1++;
                }

            }
        }

        for(int i = 0; i < arr2.length; i++) {
            if(arr2[i] == arr2[0]) {
                continue;
            } else {
                if(arr2[i] == arr2[arr2.length-1]) {
                    break;
                } else {
                    count2++;
                }

            }
        }

         */



        /*
        System.out.println(answer);

        if(a == c && b == d) {
            out.println(b - a);
            out.close();
        }

        if(a == c) {
            overlap++;
        } else if(b == c) {
            overlap++;
        }


        if(overlap == -1) {
            out.println(count + count2);
            out.close();
        } else if (overlap == 0) {
            out.println(count + count2 - 1);
            out.close();
        } else {
            out.println(c);
            out.close();
        }

         */



    }
}


//67810