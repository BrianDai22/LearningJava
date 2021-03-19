package USACO.USOPEN2019;

import java.io.*;
import java.util.StringTokenizer;

public class cowJump2 {
    static double evalBaseX;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        int n = Integer.parseInt(f.readLine());
        Point[] points = new Point[n * 2];
        Segement[] segements = new Segement[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            Long x1 = Long.parseLong(st.nextToken());
            Long y1 = Long.parseLong(st.nextToken());
            Long x2 = Long.parseLong(st.nextToken());
            Long y2 = Long.parseLong(st.nextToken());
            points[i * 2] = new Point(x1, y1, i);
            points[i * 2 + 1] = new Point(x2, y2, i);
            segements[i] = new Segement(points[i * 2], points[i * 2 + 1], i);
        }

        int ans1 = -1;
        int ans2 = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (checkIntersect(segements[i], segements[j])) {
                    ans1 = i;
                    ans2 = j;
                    break;
                }
            }
            if (ans1 != -1) {
                break;
            }
        }
        int ans2IntersectAmount = 0;

        for (int i = 0; i < n; i++) {
            if (i == ans2) {
                continue;
            }
            if (checkIntersect(segements[i], segements[ans2])) {
                ans2IntersectAmount++;
            }
        }
        if (ans2IntersectAmount > 1) {
            out.println(ans2 + 1);
        } else {
            out.println(ans1 + 1);
        }
        out.close();

    }

    public static class Point {
        Long x;
        Long y;
        int segIndex;

        Point(long x, long y, int segIndex) {
            this.x = x;
            this.y = y;
            this.segIndex = segIndex;
        }
    }

    public static class Segement {

        Point p;
        Point q;
        int index;

        Segement(Point p, Point q, int index) {
            this.p = p;
            this.q = q;
            this.index = index;
        }
    }

    public static int orientation(Point p1, Point p2, Point p3) {

        long val = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);

        if (val == 0) {
            return 0;
        }

        return (val > 0) ? 1 : 2;
    }

    public static boolean checkIntersect(Segement s1, Segement s2) {
        if (orientation(s1.p, s1.q, s2.p) != orientation(s1.p, s1.q, s2.q)
                && orientation(s2.p, s2.q, s1.p) != orientation(s2.p, s2.q, s1.q)) {
            return true;
        }
        return false;
    }
}
