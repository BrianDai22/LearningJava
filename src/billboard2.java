import java.io.*;
import java.util.StringTokenizer;

public class billboard2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int b1x1 = Integer.parseInt(st.nextToken());
        int b1y1 = Integer.parseInt(st.nextToken());
        int b1x2 = Integer.parseInt(st.nextToken());
        int b1y2 = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(f.readLine());
        int b2x1 = Integer.parseInt(st2.nextToken());
        int b2y1 = Integer.parseInt(st2.nextToken());
        int b2x2 = Integer.parseInt(st2.nextToken());
        int b2y2 = Integer.parseInt(st2.nextToken());

        int b1Area = area(b1x1, b1y1, b1x2, b1y2);

        if(overlapArea(b1x1,b1y1,b1x2,b1y2,b2x1,b2y1,b2x2,b2y2) <= b1Area/2) {
            out.println(b1Area);
            out.close();
        } else {
            b1Area = b1Area - overlapArea(b1x1, b1y1, b1x2, b1y2, b2x1, b2y1, b2x2, b2y2);
            out.println(b1Area);
            out.close();
        }
    }

    public static int area(int x1, int y1, int x2, int y2) {
        return Math.abs(y1 - y2) * Math.abs(x1 - x2);
    }

    public static int overlapArea(int x1, int y1, int x2, int y2, int b2X1, int b2Y1, int b2X2, int b2Y2) {
        int overlapX1 = Math.max(x1, b2X1);
        int overlapY1 = Math.max(y1, b2Y1);
        int overlapX2 = Math.min(x2, b2X2);
        int overlapY2 = Math.min(y2, b2Y2);

        if (overlapX2 <= overlapX1 || overlapY2 <= overlapY1) {
            return 0;
        }
        return area(overlapX1,overlapY1, overlapX2, overlapY2);
    }
}
