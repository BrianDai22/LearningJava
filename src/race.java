import java.io.*;
import java.util.StringTokenizer;

public class race {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("race.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            out.println(speedy(K, Integer.parseInt(f.readLine())));
        }

        out.close();

        /*
        the key is the current speed <= speed limit, when reach to the end

        extract the min requirement for the question !!!!!

        split into speed up side and slow down side
        2 case:
            1. curSpeed < speedLimit
                keep adding speedUpDist and check totalDist with race length, no worry about slowDownDist
            2. curSpeed >= speedLimit
                for the speed, 1 sec speed up, and 1 sec to slow down
                need to update speedUpDist and slowDownDist; and check totalDist with race length

            int speedUpDist
            int slowDownDist
            totalDist = speedUpDist + slowDownDist

        * */

    }
    public static int speedy(int maxDistance, int speedLimit) {
        int timeUsed = 0;
        int speedUpDist = 0;
        int slowDownDist = 0;
        for(int i = 1;; i++) {
            speedUpDist += i;
            timeUsed++;
            if(speedUpDist+slowDownDist >= maxDistance) {
                return timeUsed;
            }
            if(i >= speedLimit) {
                slowDownDist += i;
                timeUsed++;
                if(speedUpDist+slowDownDist >= maxDistance) {
                    return timeUsed;
                }
            }
        }
    }
}
