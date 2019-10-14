import java.io.*;
import java.util.*;

public class blocks {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        int blocks = Integer.parseInt(f.readLine());
        String[] words = new String[blocks];
        int[] freq = new int[25];
        String empty = "";

        for(int i = 0; i < blocks; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            words[i] = st.nextToken() + st.nextToken();
        }

        for(int i = 0; i < blocks; i++) {
            Set<Character> charSet = new HashSet<>();
            for(int j = 0; j < words[i].length(); j++) {
                charSet.add(words[i].charAt(j));
            }
            words[i] = charSet.toString();
        }

        for(int i =0; i < blocks; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                empty += words[i].charAt(j);
            }
        }

        char[] words2 = empty.toCharArray();
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
        for(int i = 0; i < freq.length; i++) {
            out.println(freq[i]);
        }
        out.close();
    }

}
