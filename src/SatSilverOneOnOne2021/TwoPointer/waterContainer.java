package SatSilverOneOnOne2021.TwoPointer;

public class waterContainer {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int ans = 0;
        int right = arr.length-1;
        int left = 0;
        while(left < right) {
            int height = Math.min(arr[left], arr[right]);
            int length = right - left;
            ans = Math.max(height * length, ans);
            if(arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(ans);
    }
}
