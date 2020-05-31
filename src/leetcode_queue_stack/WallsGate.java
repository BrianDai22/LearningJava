package leetcode_queue_stack;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class WallsGate {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final List<Pair<Integer,Integer>> DIRECTIONS = Arrays.asList(
            new Pair<>(1,0),
            new Pair<>(-1,0),
            new Pair<>(0,1),
            new Pair<>(0,-1)
    );

    public static void wallsAndGate(int[][] rooms) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        int steps = 0;

        if (rooms.length == 0) {
            return;
        }

        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == GATE) {
                    queue.offer(new Pair<Integer, Integer>(row, col));
                    set.add(new Pair<Integer, Integer>(row, col));

                }
            }
        }

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = queue.poll();
                for (Pair<Integer, Integer> direction : DIRECTIONS) {
                    int row = cur.getKey() + direction.getKey();
                    int col = cur.getValue() + direction.getValue();
                    if (row < 0 || row >= rooms.length
                            || col < 0
                            || col >= rooms[0].length
                            || rooms[row][col] == WALL) {
                        continue;
                    }
                    Pair<Integer,Integer> neighborNode = new Pair<>(row, col);
                    if(set.contains(neighborNode)) {
                        continue;
                    }
                    rooms[row][col] = steps;
                    queue.offer(neighborNode);
                    set.add(neighborNode);
                }
            }
        }
    }
}

    /*
    public static int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        Set<Pair<Integer,Integer>> set = new HashSet<>();
        int steps = 0;
        Pair<Integer, Integer> startPoint = new Pair<>(startRow, startCol);
        queue.offer(startPoint);
        set.add(startPoint);
        while(!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = queue.peek();
                for(Pair<Integer, Integer> direction: DIRECTIONS) {
                    int row = cur.getKey() + direction.getKey();
                    int col = cur.getValue() + direction.getValue();
                    if(row < 0 || row >= rooms.length
                            || col < 0
                            || col >= rooms.length
                            || rooms[row][col] == WALL) {
                        continue;
                    }
                    if(rooms[row][col] == GATE) {
                        return steps;
                    }
                    Pair<Integer, Integer> neighborPoint = new Pair<>(row,col);
                    if(!set.contains(neighborPoint)) {
                        queue.offer(neighborPoint);
                        set.add(neighborPoint);
                    }
                }
                queue.poll();
            }

        }
        return -1;
    }
     */

