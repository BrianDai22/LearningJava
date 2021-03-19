package SatAndWedClass20182020;

import java.util.*;

public class openDaLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();

        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();

        int level = 0;

        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String s = queue.poll();

                if (visited.contains(s)) {
                    continue;
                }
                if (deadSet.contains(s)) {
                    continue;
                }
                if (s.equals(target)){
                    return level;
                }

                visited.add(s);

                char[] charArr = s.toCharArray();

                for (int j = 0; j < charArr.length; j++) {
                    char temp = charArr[j];

                    if (charArr[j] < '9') {
                        charArr[j]++;
                    }  else {
                        charArr[j] = '0';
                    }

                    queue.offer(new String(charArr));
                    charArr[j] = temp;

                    if (charArr[j] > '0') {
                        charArr[j]--;
                    } else {
                        charArr[j] = '9';
                    }

                    queue.offer(new String(charArr));
                    charArr[j] = temp;
                }
            }
            level++;
        }
        return -1;
    }
}
