package SatAndWedClass20182020;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class perfectSqaue {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        if(n > 0) {
            queue.offer(n);
        }
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int val = queue.poll();
                if(!set.add(val)) {
                    continue;
                }
                for(int j = 1; j <= Math.sqrt(val); j++){
                    if(val - (j*j) == 0) {
                        return level;
                    }
                    queue.offer(val - (j*j));
                }
            }
        }

        return level;
    }
}
