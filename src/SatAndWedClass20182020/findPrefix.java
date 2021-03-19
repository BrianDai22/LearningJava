package SatAndWedClass20182020;

import java.util.ArrayList;
import java.util.List;

public class findPrefix {
    /*
    Given a String str contains multiple words, seperated by space, given another String prefix,
    find out all words which contain the prefix string as prefix,
    return the start index for each USACO.Jan2020.word.
    All letters are case insensitive ('a' equivlent to 'A').

String document = "a aa Aaa abca bca"

"a"    ->  [0, 2, 5, 9]
"aA"   ->  [2,5]
"bc"   ->  [14]


     */

    public static void main(String[] args) {
        String document = "a aa Aaa abca bca".toLowerCase();
        String prefix = "aA".toLowerCase();
        String[] arr2 = document.split(" ");
        //int[][] count = new int[arr2.length][arr2.length];
        List<Integer> strLength = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int pos = 0; // length so far


        for(int i = 0; i < arr2.length; i++) {
            strLength.add(arr2[i].length()+1);
            if(prefix.length() <= arr2[i].length() &&  arr2[i].substring(0, prefix.length()).equals(prefix)) {
               result.add(pos);
               pos+=strLength.get(i);
            }else{
                pos+=strLength.get(i);
            }
        }

        System.out.println(result);

    }


}
