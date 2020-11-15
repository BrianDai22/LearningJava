import java.util.*;

public class courses {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{4,2}, {5,1}, {3,2}, {2,1}, {1,0}};
        int numCourses = 6;
        System.out.println(mainv2(numCourses, prerequisites));
    }

    public static boolean mainv2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> data = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            data.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int required = prerequisites[i][1];
            int chosenClass = prerequisites[i][0];
            data.get(required).add(chosenClass);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if (!DFS(visited, i, data)) {
                return false;
            }
        }
        return true;
    }

    public static boolean DFS(int[] visited, int start, List<List<Integer>> data) {
        visited[start] = 1;
        List<Integer> chosenClasses = data.get(start);

        for(int i = 0; i < chosenClasses.size(); i++) {
            int chosenClass = chosenClasses.get(i);
            if(visited[chosenClass] == 1) {
                return false;
            }
            if(visited[chosenClass] == 0) {
                if(!DFS(visited,chosenClass,data)) {
                    return false;
                }
            }
        }
        visited[start] = 2;
        return true;
    }
}
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should
also have finished course 1. So it is impossible.
 */