package Other;

import java.util.*;

public class roblox1 {
/*
* Complete the 'getMaxUnits' function below.
The function is expected to return a LONG_INTEGER.
The function accepts following parameters:
1. LONG_INTEGER_ARRAY boxes
2. LONG_INTEGER_ARRAY unitsPerBox
3. LONG_INTEGER truckSize
*/
    public static class Box {
        Long value;
        Long size;
        Box(long value, long size) {
            this.value = value;
            this.size = size;
        }
    }

    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        long answer = 0;
        long packages = 0;
        PriorityQueue<Box> prioQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < boxes.size(); i++) {
            prioQ.add(new Box(boxes.get(i), unitsPerBox.get(i)));
        }
        while(packages < truckSize) {
            Box cur = prioQ.poll();
            for(long i = 0; i < cur.size; i++) {
                answer += cur.value;
                packages++;
            }
        }
        return answer;
    }
}
