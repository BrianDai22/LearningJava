package SatAndWedClass20182020;

import java.util.TreeMap;

public class calender2 {
    /*Based on MyCalendar, we upgrade the booking system a little bit.
A new event can be added if adding the event will not cause a triple booking.
Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
A triple booking violation happens when three events have some non-empty intersection
Return true if the event can be added to the calendar successfully without causing a triple booking violation. Otherwise, return false and do not add the event to the calendar.
Example 1:
MyCalendarV2();
MyCalendarV2.book(10, 20); // returns true
MyCalendarV2.book(50, 60); // returns true
MyCalendarV2.book(10, 40); // returns true
MyCalendarV2.book(5, 15); // returns false
MyCalendarV2.book(5, 10); // returns true
MyCalendarV2.book(25, 55); // returns true
Explanation:
The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
----------------------- Init code --------------------
Hint: use TreeMap to solve, do some research on TreeMap

     */
    private static TreeMap<Integer, Integer> booked;

    public calender2() {
        booked = new TreeMap<>();
    }

    public static boolean book(int start, int end) {
        // TODO
        booked.put(start, booked.getOrDefault(start, 0) + 1);
        booked.put(end, booked.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int days : booked.values()) {
            active += days;
            if (active >= 3) {
                booked.put(start, booked.get(start) - 1);
                booked.put(end, booked.get(end) + 1);
                if (booked.get(start) == 0) {
                    booked.remove(start);
                }
                return false;
            }
        }
        return true;
    }
}
