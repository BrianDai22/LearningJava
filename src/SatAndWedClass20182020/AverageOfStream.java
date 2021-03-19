package SatAndWedClass20182020;

import java.util.LinkedList;
import java.util.Queue;

public class AverageOfStream {
    // Initialize your data structure here.

    private static double sum;
    private static double divide;
    private static double temp;
    private static Queue<Integer> queue;


    public AverageOfStream(int size) {
        divide = size;
        queue = new LinkedList<>();
    }


    public double next(int val) {
        if(temp < divide) {
            temp++;
        }
        queue.add(val);
        if (queue.size() == 1) {
            return val;
        }
        if (queue.size() > divide) {
            queue.remove();
        }
        sum = 0;
        for (int x : queue) {
            sum += x;
        }

        return sum / temp;
}

    public static void main(String[] args) {
        AverageOfStream averageOfStream = new AverageOfStream(3);
        double val1 = averageOfStream.next(1);
        double val2 = averageOfStream.next(10);
        double val3 = averageOfStream.next(3);
        double val4 = averageOfStream.next(5);
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);

    }
}

/*

        Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

        Example:

        MovingAverage m = new MovingAverage(3);
        m.next(1) = 1
        m.next(10) = (1 + 10) / 2
        m.next(3) = (1 + 10 + 3) / 3
        m.next(5) = (10 + 3 + 5) / 3
        */
