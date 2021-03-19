package USACO.Dec2016;

import java.io.*;
import java.util.*;

public class blocks {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2016.blocks.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2016.blocks.out")));

        int blocks = Integer.parseInt(f.readLine());
        String[] words = new String[blocks];
        String[] words2 = new String[blocks];
        int[] freq = new int[26];

        for (int i = 0; i < blocks; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            words[i] = st.nextToken();
            words2[i] = st.nextToken();
        }

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < blocks; i++) {

            for(int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));

            }
            for(int k = 0; k < words2[i].length(); k++) {
                set.add(words2[i].charAt(k));
            }
            System.out.println(set);

            for(int h = 0; h < set.size(); h++) {
                if (set.contains('a')) {
                    freq[0]++;
                    set.remove('a');
                    continue;
                }
                if(set.contains('b')) {
                    freq[1]++;
                    set.remove('b');
                    continue;
                }
                if(set.contains('c')) {
                    freq[2]++;
                    set.remove('c');
                    continue;
                }
                if(set.contains('d')) {
                    freq[3]++;
                    set.remove('d');
                    continue;
                }
                if(set.contains('e')) {
                    freq[4]++;
                    set.remove('e');
                    continue;
                }
                if(set.contains('f')) {
                    freq[5]++;
                    set.remove('f');
                    continue;
                }
                if(set.contains('g')) {
                    freq[6]++;
                    set.remove('g');
                    continue;
                }
                if(set.contains('h')) {
                    freq[7]++;
                    set.remove('h');
                    continue;
                }
                if(set.contains('i')) {
                    freq[8]++;
                    set.remove('i');
                    continue;
                }
                if(set.contains('j')) {
                    freq[9]++;
                    set.remove('j');
                    continue;
                }
                if(set.contains('k')) {
                    freq[10]++;
                    set.remove('k');
                    continue;
                }
                if(set.contains('l')) {
                    freq[11]++;
                    set.remove('l');
                    continue;
                }
                if(set.contains('m')) {
                    freq[12]++;
                    set.remove('m');
                    continue;
                }
                if(set.contains('n')) {
                    freq[13]++;
                    set.remove('n');
                    continue;
                }
                if(set.contains('o')) {
                    freq[14]++;
                    set.remove('o');
                    continue;
                }
                if(set.contains('p')) {
                    freq[15]++;
                    set.remove('p');
                    continue;
                }
                if(set.contains('q')) {
                    freq[16]++;
                    set.remove('q');
                    continue;
                }
                if(set.contains('r')) {
                    freq[17]++;
                    set.remove('r');
                    continue;
                }
                if(set.contains('s')) {
                    freq[18]++;
                    set.remove('s');
                    continue;
                }
                if(set.contains('t')) {
                    freq[19]++;
                    set.remove('t');
                    continue;
                }
                if(set.contains('u')) {
                    freq[20]++;
                    set.remove('u');
                    continue;
                }
                if(set.contains('v')) {
                    freq[21]++;
                    set.remove('v');
                    continue;
                }
                if(set.contains('w')) {
                    freq[22]++;
                    set.remove('w');
                    continue;
                }
                if(set.contains('x')) {
                    freq[23]++;
                    set.remove('x');
                    continue;
                }
                if(set.contains('y')) {
                    freq[24]++;
                    set.remove('y');
                    continue;
                }
                if(set.contains('z')) {
                    freq[25]++;
                    set.remove('z');

                }
            }
        }

        for(int i = 0; i < freq.length; i++) {
            out.println(freq[i]);
        }
        out.close();

    }
}
 /*
        for(int i = 0; i < USACO.Dec2016.blocks; i++) {
            Set<Character> charSet = new HashSet<>();
            for(int j = 0; j < words[i].length(); j++) {
                charSet.add(words[i].charAt(j));
            }
            words[i] = charSet.toString();
        }

        for(int i =0; i < USACO.Dec2016.blocks; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                empty += words[i].charAt(j);
            }
        }
        */

/*
        for(int i = 0; i < words2.length; i++) {
            switch (words2[i]) {
                case('a'):
                    freq[0]++;
                    break;
                case('b'):
                    freq[1]++;
                    break;
                case('c'):
                    freq[2]++;
                    break;
                case('d'):
                    freq[3]++;
                    break;
                case('e'):
                    freq[4]++;
                    break;
                case('f'):
                    freq[5]++;
                    break;
                case('g'):
                    freq[6]++;
                    break;
                case('h'):
                    freq[7]++;
                    break;
                case('i'):
                    freq[8]++;
                    break;
                case('j'):
                    freq[9]++;
                    break;
                case('k'):
                    freq[10]++;
                    break;
                case('l'):
                    freq[11]++;
                    break;
                case('m'):
                    freq[12]++;
                    break;
                case('n'):
                    freq[13]++;
                    break;
                case('o'):
                    freq[14]++;
                    break;
                case('p'):
                    freq[15]++;
                    break;
                case('q'):
                    freq[16]++;
                    break;
                case('r'):
                    freq[17]++;
                    break;
                case('s'):
                    freq[18]++;
                    break;
                case('t'):
                    freq[19]++;
                    break;
                case('u'):
                    freq[20]++;
                    break;
                case('v'):
                    freq[21]++;
                    break;
                case('w'):
                    freq[22]++;
                    break;
                case('x'):
                    freq[23]++;
                    break;
                case('y'):
                    freq[24]++;
                    break;
                case('z'):
                    freq[25]++;
                    break;
            }
         }

 */
