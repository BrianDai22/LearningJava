import java.lang.reflect.Array;
import java.util.*;

public class beginWord2 {
    public static ArrayList<String> arr;
    public static void main(String[] args) {
        List<String> s = new LinkedList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        String endWord = "cog";
        int[] paths = new int[s.size()];
        for(int i = 0; i < paths.length; i++) {
            if(s.get(i).equals(endWord)) {
                continue;
            }
            paths[i] = ladderLength(s.get(i), endWord, s);
        }

        int[] pathsClone = paths.clone();
        Arrays.sort(pathsClone);

        for(int i = 0; i < paths.length; i++) {
            arr = new ArrayList<>();
            if(paths[i] == pathsClone[1]) {
                ladderLength2(s.get(i), endWord, s);
                System.out.println(arr);
            }
        }
        //System.out.println(Arrays.toString(paths));
    }
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

    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
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
                arr.add(w);
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
