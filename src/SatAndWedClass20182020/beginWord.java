package SatAndWedClass20182020;

import java.util.*;

public class beginWord {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int length = 0;
        set.add(endWord);
        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.equals(endWord)) {
                    return length + 1;
                }
                wordMatch(w, set, q);
            }
            length++;
        }
        return 0;
    }

    public static void wordMatch(String w, Set<String> set, Queue<String> q) {
        for (int i = 0; i < w.length(); i++) {
            char[] word = w.toCharArray();
            for (char j = 'a'; j < 'z'; j++) {
                if (word[i] == j) {
                    continue;
                }
                word[i] = j;
                String s = String.valueOf(word);
                if (set.contains(s)) {
                    set.remove(s);
                    q.offer(s);
                }
            }
        }
    }
}
/*
Given two words (WednesdayClass.beginWord and endWord), and a dictionary's USACO.Jan2020.word list,
find the length of shortest transformation sequence from WednesdayClass.beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed USACO.Jan2020.word must exist in the USACO.Jan2020.word list.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the USACO.Jan2020.word list.
You may assume WednesdayClass.beginWord and endWord are non-empty and are not the same.
Example 1:
Input:
WednesdayClass.beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:
Input:
WednesdayClass.beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */