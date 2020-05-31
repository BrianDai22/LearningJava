import java.util.*;

public class opendalockHansVersion {
    public int openLock(String[] deadends, String target) {
        int[] DIRECTIONS = new int[]{-1,1};
        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        if(deadendSet.contains(start)) {
            return -1;
        }

        queue.offer(start);
        visited.add(start);

        int step = 0;

        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String node = queue.poll();
                for(int j = 0; j < 4; j++) {
                    for(int direction: DIRECTIONS) {
                        String neighbor = node.substring(0,j) +
                                (node.charAt(j) - '0' + direction + 10) % 10 +
                                node.substring(j + 1);
                        if(neighbor.equals(target)) {
                            return step;
                        }
                        if(!deadendSet.contains(neighbor) && !visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
