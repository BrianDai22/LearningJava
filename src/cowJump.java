public class cowJump {
    static double evalBaseX;

    public static class Point implements Comparable<Point> {
        Long x;
        Long y;
        int segIndex;
        @Override
        public int compareTo(Point point) {
            if(this.x.equals(point.x)) {
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
            if(this.index == segement.index) {
                return 0;
            }
            return 0;
        }

        Segement(Point p, Point q, int index) {
            this.p = p;
            this.q = q;
            this.index = index;
        }
    }



}
