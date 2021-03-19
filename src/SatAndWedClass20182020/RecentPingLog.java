package SatAndWedClass20182020;

import java.util.LinkedList;
import java.util.Queue;

public class RecentPingLog {
    // Initialize your data structure here.

    Queue<Integer> q;

    public RecentPingLog() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000){
            q.poll();
        }

        return q.size();
    }

    public static void main(String[] args) {
        RecentPingLog recentPingLog = new RecentPingLog();
        System.out.println(recentPingLog.ping(1));
        System.out.println(recentPingLog.ping(100));
        System.out.println(recentPingLog.ping(3001));
        System.out.println(recentPingLog.ping(3002));

    }
}



/*
        Write a class SatAndWedClass20182020.RecentPingLog to count recent requests.

        It has only one method: ping(int t), where t represents some time in milliseconds.

        Return the number of pings that have been made from 3000 milliseconds ago until now.

        Any ping with time in [t - 3000, t] will count, including the current ping.

        It is guaranteed that every call to ping uses a strictly larger value of t than before.



        Example 1:

        Input: inputs = ["ping","ping","ping","ping"], inputs = [[1],[100],[3001],[3002]]
        Output: [1,2,3,3]
*/