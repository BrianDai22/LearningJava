package USACOSILVER.Week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class highcard {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("highcard.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
        int numOfCards = Integer.parseInt(f.readLine());
        ArrayList<Integer> elsieCards = new ArrayList<>();
        ArrayList<Integer> bessieCards = new ArrayList<>();
        boolean[] bessieCardsHelper = new boolean[numOfCards*2 + 2];
        int winnableMatchups = 0;
        for(int i = 0; i < numOfCards; i++) {
            elsieCards.add(Integer.parseInt(f.readLine()));
        }
        for(int x: elsieCards) {
            bessieCardsHelper[x] = true;
        }
        for(int i = 1; i <= numOfCards*2; i++) {
            if(!bessieCardsHelper[i]) {
                bessieCards.add(i);
            }
        }
        elsieCards.sort(Collections.reverseOrder());
        bessieCards.sort(Collections.reverseOrder());
        int elsieDeleted = 0;
        int bessieDeleted = 0;
        while (elsieDeleted != numOfCards && bessieDeleted != numOfCards) {
            if(bessieCards.get(bessieDeleted) < elsieCards.get(elsieDeleted)) {
                elsieDeleted++;
            } else {
                elsieDeleted++;
                bessieDeleted++;
                winnableMatchups++;
            }
        }

        out.println(winnableMatchups);
        out.close();
    }
}
//1,4,6
//2,3,5
/*
System.out.println(bessieCards);
System.out.println(elsieCards);
 */