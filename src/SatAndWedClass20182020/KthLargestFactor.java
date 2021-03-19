package SatAndWedClass20182020;

import java.util.PriorityQueue;

public class KthLargestFactor {
    /*
    Find the kth largest element in an unsorted array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.
    Example 1:
    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    Example 2:
    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4

     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        /*
        for(int i = 0; i < nums.length; i++) {
            if(queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if(queue.peek() < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
         */

        return queue.peek();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }
}