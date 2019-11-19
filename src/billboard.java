import java.io.*;
import java.util.StringTokenizer;

public class billboard {
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

        StringTokenizer st3 = new StringTokenizer(f.readLine());
        int truckx1 = Integer.parseInt(st3.nextToken());
        int trucky1 = Integer.parseInt(st3.nextToken());
        int truckx2 = Integer.parseInt(st3.nextToken());
        int trucky2 = Integer.parseInt(st3.nextToken());

        int b1Area = area(b1x1,b1y1,b1x2,b1y2);
        int b2Area = area(b2x1,b2y1,b2x2,b2y2);

        b1Area = b1Area - overlapArea(b1x1,b1y1,b1x2,b1y2,truckx1,trucky1,truckx2,trucky2);
        System.out.println(b1Area);
        b2Area = b2Area - overlapArea(b2x1,b2y1,b2x2,b2y2,truckx1,trucky1,truckx2,trucky2);
        System.out.println(overlapArea(b2x1,b2y1,b2x2,b2y2,truckx1,trucky1,truckx2,trucky2));

        //System.out.println(b1Area);
        //System.out.println(b2Area);



        out.println(b1Area + b2Area);
        out.close();



    }
    public static int area(int x1, int y1, int x2, int y2) {
        return Math.abs(y1-y2) * Math.abs(x1-x2);
    }

    public static int overlapArea(int x1, int y1, int x2, int y2,int truckX1, int truckY1, int truckX2, int truckY2) {
        int overlapX1 = Math.max(x1, truckX1);
        int overlapY1 = Math.max(y1, truckY1);
        int overlapX2 = Math.min(x2, truckX2);
        int overlapY2 = Math.min(y2, truckY2);

        if(overlapX2 <= overlapX1 || overlapY2 <= overlapY1) {
            return 0;
        }

        /*
        1 2 3 5
        6 0 10 4
        2 1 8 3

        6
        2
        3
        4
         */

        return area(overlapX1,overlapY1, overlapX2, overlapY2);
    }
}
