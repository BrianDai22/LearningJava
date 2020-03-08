import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Premutation {
   static void permute(int[] nums, int k, List<List<Integer>> result) {
        for(int i = k; i < nums.length; i++) {
            swap(nums, k, i);
            permute(nums, k +1,result);
            swap(nums,i,k);

        }
        if(k == nums.length-1) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int item : nums) {
                temp.add(item);
            }
            result.add(temp);
            System.out.println(Arrays.toString(nums));
        }
    }

    static void swap(int[] nums, int k, int i) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[1000];
        int temp = 1;
        for(int i = 0; i < 1000; i++) {
            nums[i] = temp;
            temp++;
        }
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        System.out.println(result);
    }

    /*
    * 1, 2, 3, 4
    * 1,[x [y,y]] =>
    * 1. get all combinnations in List of List<String>
    *   arr 1: [Buttercup, Blue, Sue]
    *   arr 2: [Bella, Bella, Beatrice]
    * 2. loop all possible lists
    *   e.g. [a,buttercup,bella,d,e,f,g,h]
    *   check Math.abs(list.indexof(arr1[0]) - list.indexof(arr2[0])) == 1 or not  // narrow down
    * 3. sort and get 1 alphabetlly element
    *
    * */

}
