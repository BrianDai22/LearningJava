

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), 1);
            } else {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            }
        }
        System.out.println(map);
        System.out.println(map2);

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsValue(map2.get(t.charAt(i))) && !map2.containsValue(map.get(s.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "odo";
        System.out.println(isIsomorphic(s,t));
    }
}

/*
        Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving the order of characters.
        No two characters may map to the same character but a character may map to itself.

        Example 1:

        Input: s = "egg", t = "add"
        Output: true
        Example 2:

        Input: s = "foo", t = "bar"
        Output: false
        Example 3:

        Input: s = "paper", t = "title"
        Output: true
        Note:
        You may assume both s and t have the same length.
*/