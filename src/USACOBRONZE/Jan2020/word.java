package USACOBRONZE.Jan2020;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
ID: braindia
LANG: JAVA
TASK: USACO.Jan2020.word
*/
public class word {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Jan2020.word.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Jan2020.word.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int words = Integer.parseInt(st.nextToken());
        int characterInEachLine = Integer.parseInt(st.nextToken());
        String[] eachWord;
        String sentence = "";
        ArrayList<String> arr = new ArrayList<>();
        st = new StringTokenizer(f.readLine());

        //add sentence into a string with spaces
        for(int i = 0; i < words; i++) {
            sentence += st.nextToken() + " ";
        }
        //make sentence into array seperated by words
        eachWord = sentence.split(" ");

        String temp = "";
        //make a loop checking parameters
        for(int i = 0; i < words; i++) {
            //checks if USACO.Jan2020.word has more characters than allowed, if yes, than adds USACO.Jan2020.word and continues,
            // if no, than keeps on adding new words to original USACO.Jan2020.word
            if(eachWord[i].length() + temp.replaceAll(" ","").length() > characterInEachLine) {
                arr.add(temp);
                temp = eachWord[i];
                continue;
            }
            //check if its the first loop
            if(i == 0) {
                temp += eachWord[i];
            } else {
                //if not than adds USACO.Jan2020.word with space if the if statement above was able to pass
                temp += " " + eachWord[i];
            }
        }
        //finish adding words
        arr.add(temp);

        //this is the way to print
        for(String s: arr) {
            out.println(s);
        }

        out.close();

    }
}
