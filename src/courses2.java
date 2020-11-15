import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courses2 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{4,2}, {5,1}, {3,2}, {2,1}, {1,0}};
        int numCourses = 6;
        System.out.println(courses(numCourses, prerequisites));
    }
    public static boolean courses(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        //indegree[0] = 0, indegree[1] = 1, indegree[2] = 1, indegree[3] = 1, indegree[4] = 1, indegree[5] = 1
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
           for(int i = 0; i < prerequisites.length; i++) {
               if(indegree[prerequisites[i][0]] == 0) {
                   continue;
               }
               if(prerequisites[i][1] == cur) {
                   indegree[prerequisites[i][0]]--;
               }
               if(indegree[prerequisites[i][0]] == 0) {
                   q.add(prerequisites[i][0]);
               }
           }
        }
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
