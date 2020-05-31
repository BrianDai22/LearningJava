public class cowJump2 {
    static double evalBaseX;

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



}
