package SatSilverOneOnOne2021.GraphTheory;

import java.util.LinkedList;
import java.util.Queue;

public class Prerequisites {
    public static void main(String[] args) {
        int courses = 2;
        int[][] data = new int[][]{{1, 0},{0,1}};
        int[] coursesNeedPre = new int[courses];
        for(int i = 0; i < data.length; i++) {
            coursesNeedPre[data[i][0]]++;
        }

        System.out.println(BFS(coursesNeedPre, data));

    }
    public static boolean BFS(int[] coursesNeedPre, int[][] data) {
        Queue<Integer> doableClasses = new LinkedList<>();
        for(int i = 0; i < coursesNeedPre.length; i++) {
            if(coursesNeedPre[i] == 0) {
                doableClasses.add(i);
            }
        }
        while(!doableClasses.isEmpty()) {
            int startingClass = doableClasses.poll();
            for(int i = 0; i < data.length; i++) {
                if(data[i][1] == startingClass) {
                    coursesNeedPre[data[i][0]]--;
                    if(coursesNeedPre[data[i][0]] == 0) {
                        doableClasses.add(data[i][0]);
                    }
                }
            }
        }
        for(int i = 0; i < coursesNeedPre.length; i++) {
            if(coursesNeedPre[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
