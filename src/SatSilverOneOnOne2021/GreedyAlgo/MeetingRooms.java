package SatSilverOneOnOne2021.GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30}, {5,10}, {15,20}};
        int rooms = 1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> schedule = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        schedule.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= schedule.peek()[1]) {
                schedule.poll();
            } else {
                rooms++;
            }
            schedule.add(intervals[i]);
        }
        System.out.println(rooms);
    }
}
/*
Given an array of meeting time intervals intervals where intervals[i] = [start, end], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:

1 <= intervals.length <= 10^4
0 <= start < end <= 10^6
 */