package SatAndWedClass20182020;

public class calender {
    /*
    Implement a MyCalendar to store your events. A new event can be added if adding the event will not cause a double booking.
Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation:
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
     */
    // arr[1000]
    // 1 1 1 1 1 1 1 1 1 1 1 0
    // 1 1 1 1 1 2 2 2 2 1 1 1

    private static int[] transcript = new int[1000];

    public static boolean calenderChecker(int start, int end) {
        boolean isGood = true;

        for (int i = start; i < end; i++) {
            transcript[i]++;
        }

        for (int i = start; i < end; i++) {
            if (transcript[i] >= 2) {
                isGood = false;
                break;
            }
        }

        if(!isGood) {
            for (int i = start; i < end; i++) {
                transcript[i]--;
            }
        }

        return isGood;
    }

    public static void main(String[] args) {
        System.out.println(calender.calenderChecker(10,20));
        System.out.println(calender.calenderChecker(15,25));
        System.out.println(calender.calenderChecker(20,30));
    }
}
