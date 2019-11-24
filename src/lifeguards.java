import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        int workers = Integer.parseInt(f.readLine());
        int[][] timeslots = new int[workers][2];

        for(int i = 0; i < workers; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            timeslots[i][0] = Integer.parseInt(st.nextToken());
            timeslots[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] trans = new int[1000];
        int answer = 0;

        for(int i = 0; i < workers; i++) {
            for (int j = timeslots[i][0]; j < timeslots[i][1]; j++) {
                trans[j]++;
            }
        }

        for(int i = 0; i < workers; i++) {
            for(int j = timeslots[i][0]; j < timeslots[i][1]; j++) {
                trans[j]--;
            }
            int maxTime = 0;
            for(int k = 0; k < 1000; k++) {
                if(trans[k] > 0) {
                    maxTime++;
                }
            }
            for(int l = timeslots[i][0]; l < timeslots[i][1]; l++) {
                trans[l]++;
            }
            answer = Math.max(maxTime,answer);
        }
        /*
        int maxTime = 0;
        int temp = 0;
        for(int i = 0; i < workers;i++) {
            for(int j = i + 1; j < workers; j++) {
                if(timeslots[i][0] < timeslots[j][0] && timeslots[i][0] < timeslots[j][1]
                        && timeslots[i][1] < timeslots[j][0] && timeslots[i][1] < timeslots[j][1] ||
                        timeslots[i][0] > timeslots[j][0] && timeslots[i][0] > timeslots[j][1]
                        && timeslots[i][1] > timeslots[j][0] && timeslots[i][1] > timeslots[j][1] ||
                        timeslots[j][0] > timeslots[i][0] && timeslots[j][0] > timeslots[i][1]
                        && timeslots[j][1] > timeslots[i][0] && timeslots[j][1] > timeslots[i][1] ||
                        timeslots[j][0] < timeslots[i][0] && timeslots[j][0] < timeslots[i][1]
                        && timeslots[j][1] < timeslots[i][0] && timeslots[j][1] < timeslots[i][1]) {

                    //System.out.println(timeslots[i][0]);
                    //System.out.println(timeslots[i][1]);
                    //System.out.println(timeslots[j][0]);
                    //System.out.println(timeslots[j][1]);

                    temp = Math.abs(timeslots[i][0] - timeslots[i][1]);
                    temp += Math.abs(timeslots[j][0] - timeslots[j][1]);

                    //System.out.println(temp);
                } else {
                    temp = Math.abs(Math.min(timeslots[i][0], timeslots[j][0]) - Math.max(timeslots[i][1],timeslots[j][1]));
                }
            }
            System.out.println(temp);
            maxTime = Math.max(maxTime,temp);

        }

        System.out.println(Arrays.deepToString(timeslots));
        System.out.println(maxTime);

         */

        out.println(answer);
        out.close();
    }
}
