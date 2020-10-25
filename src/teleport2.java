import java.io.*;
import java.util.StringTokenizer;

public class teleport2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
        StringTokenizer st;
        int N = Integer.parseInt(f.readLine());
        int[] start = new int[N];
        int[] end = new int[N];
        int farthestLeft = Integer.MAX_VALUE;
        int farthestRight = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
            farthestLeft = Math.min(farthestLeft, Math.min(start[i],end[i]));
            farthestRight = Math.max(farthestRight, Math.max(start[i],end[i]));
        }
        int maxDistance = 0;
        for(int i = 0; i < N; i++) {
            maxDistance += Math.abs(start[i]-end[i]);
        }

        int minDistance = Integer.MAX_VALUE;
        int answer = 0;
        int y = 0;

        while(y <= farthestRight) {
            int temp = maxDistance;
            for(int i = 0; i < N; i++) {
                if(start[i] < 0 && end[i] > 0 || start[i] > 0 && end[i] < 0) {
                    temp -= Math.abs(start[i]) + y;
                }
                if(start[i] < 0 && end[i] < 0 || start[i] > 0 && end[i] > 0) {
                    temp -= Math.abs(start[i] - end[i]);
                }
            }
            if(temp < minDistance) {
                minDistance = temp;
                answer = y;
            }
            y++;
        }

        out.println(answer);
        out.close();
    }
}
