package USACOBRONZE.USOPEN2019;

import java.io.*;
import java.util.*;

public class cowJump {
    static double evalBaseX; // x coordinate to evaluate Segements y coordinate at x

    public static class Point implements Comparable<Point> {
        Long x;
        Long y;
        int segIndex;

        @Override
        public int compareTo(Point point) {
            if (this.x.equals(point.x)) {
                return this.y.compareTo(point.y);
            }
            return this.x.compareTo(point.x);
        }

        Point(long x, long y, int segIndex) {
            this.x = x;
            this.y = y;
            this.segIndex = segIndex;
        }
    }

    public static class Segement implements Comparable<Segement> {

        Point p;
        Point q;
        int index;

        @Override
        public int compareTo(Segement segement) {
            if (this.index == segement.index) {
                return 0;
            }
            if(eval(this) > eval(segement)) {
                return 1;
            } else {
                return -1;
            }
        }

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

    //what is the y coordinate of segement x when evaluated at evalBaseX
    public static double eval(Segement s) {
        //checks if the line is vertical
        if (s.p.x.equals(s.q.x)) {
            return s.p.y;
        }
        //if its not vertical line then use a math formula
        return s.p.y + (s.q.y - s.p.y) * (evalBaseX - s.p.x) / (s.q.x - s.p.x);
    }

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
        Arrays.sort(points);
        TreeSet<Segement> active = new TreeSet<>();

        int ans1 = -1;
        int ans2 = -1;

        for (Point p : points) {
            evalBaseX = p.x;
            Segement currentSeg = segements[p.segIndex];
            if (active.contains(currentSeg)) {
                Segement lowerNeighbor = active.lower(currentSeg);
                Segement higherNeighbor = active.higher(currentSeg);
                if(lowerNeighbor != null && higherNeighbor != null
                        && checkIntersect(higherNeighbor, lowerNeighbor)) {
                    ans1 = higherNeighbor.index;
                    ans2 = lowerNeighbor.index;
                    break;
                }
                active.remove(currentSeg);
            } else {
                active.add(currentSeg);
                //find lower neighbor in the treeset
                Segement lowerNeighbor = active.lower(currentSeg);
                if(lowerNeighbor != null && checkIntersect(currentSeg,lowerNeighbor)) {
                    ans1 = currentSeg.index;
                    ans2 = lowerNeighbor.index;
                    break;
                }
                //find higher neighbor in treeset
                Segement higherNeighbor = active.higher(currentSeg);
                if(higherNeighbor != null && checkIntersect(currentSeg,higherNeighbor)) {
                    ans1 = currentSeg.index;
                    ans2 = higherNeighbor.index;
                    break;
                }
            }
        }


        if(ans1 > ans2) {
            int temp = ans1;
            ans1 = ans2;
            ans2 = temp;
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
}
