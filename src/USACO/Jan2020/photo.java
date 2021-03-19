package USACO.Jan2020;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
ID: braindia
LANG: JAVA
TASK: USACO.Jan2020.photo
*/

public class photo {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Jan2020.photo.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Jan2020.photo.out")));
        int N = Integer.parseInt(f.readLine());
        int[] nums = new int[N-1];
        int[] permutationArr = new int[N];
        int total = 0;
        int total2 = 0;
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            total+= nums[i];
        }

        int temp = 1;
        for(int i = 0; i < N; i++) {
            permutationArr[i] = temp;
            total2 += permutationArr[i];
            temp++;
        }



        List<List<Integer>> result = new ArrayList<>();
        permute(permutationArr,0,result,total2 * 2, total, nums);
        //System.out.println(result);



        int[] tempArr = new int[N];
        for(List x: result) {
            int temp3 = 0;
            int temp4 = 0;
            int count = 0;
            for(Object y: x) {
                tempArr[temp4] = (Integer) y;
                if(temp4 + 1 < N) {
                    temp4++;
                }
            }

            for(int i = 0; i < N-1; i++) {
                if(tempArr[i] + tempArr[i + 1] == nums[temp3]) {
                    count++;
                    temp3++;
                } else {
                    break;
                }
            }

            if(count == nums.length) {
               break;
            }
        }

        for(int i = 0; i < N; i++) {
            if(i == N-1) {
                out.print(tempArr[i]);
                break;
            }
            out.print(tempArr[i] + " ");
        }
        out.close();

    }

    static void permute(int[] nums, int k, List<List<Integer>> result, int limit, int limit2, int[] limit3) {



        for (int i = k; i < nums.length; i++) {
            swap(nums, k, i);
            permute(nums, k + 1, result, limit, limit2, limit3);
            swap(nums, i, k);
        }


            if (nums[nums.length - 1] + nums[0] == limit - limit2) {
                if (k == nums.length - 1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int item : nums) {
                        temp.add(item);
                    }
                    result.add(temp);
                }
        }
    }

    static void swap(int[] nums, int k, int i) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }

}

/*
 System.out.println(Arrays.toString(b));



        for(int i = 1; i <= N; i++) {
            int[] ans = new int[N+2];
            int[] freq = new int[N+2];
            boolean good = true;
            ans[1] = i;
            freq[ans[1]]++; //{ 0,1,0,0,0 }
             for(int k = 2; k <= N; k++) {
                ans[k] = b[k-1] - ans[k-1];
                if(ans[k] < 1 || ans[k] > N) {
                    good = false;
                    break;
                }
                freq[ans[k]]++;
                if(freq[ans[k]] != 1) {
                    good = false;
                    break;
                }
            }
            if(good) {
                for(int p = 1; p <= N; p++) {
                    if(p == 1) {
                        out.print(ans[p]);
                    } else {
                        out.print(" " + ans[p]);
                    }
                }
                break;
            }
        }
        out.close();

        /*
        5
        b[]: 4 6 7 6

        ans[] 3  1  5 2 4
             a0  a1 ...
        frequency[] ==> {1,1,1,1,1}
        try a0 = 3
        * b[]

        * ans[]
        ans[0] = 3 ==> mannually try from 1 to N
        ans[1] = b[0] - a0 = 1
        ans[2] = b[1] - a1 = 6-1 = 5
        ...
        ans[i] = b[i-1] - ai-1

        // key step: need  frequency[k], k -> ans[i] => check frequency[ans[i]] == 1 or not
        // waht is good answer?
            1. ans[i] = b[i-1] - ai-1
            2. all frequency[k] == 1
        *
        *
        * */

