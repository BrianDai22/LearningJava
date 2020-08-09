public class BinarySearch {
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    public static int binarySearch(int[] arr, int left,
                                   int right, int x) {

        if(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[mid] > x) {
                return binarySearch(arr, left, mid-1, x);
            }
            if(arr[mid] < x) {
                return binarySearch(arr, mid+1, right, x);
            }
        }
        return -1;
    }
}
