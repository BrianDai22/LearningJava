package SatAndWedClass20182020;

import java.util.LinkedList;
import java.util.List;

public class pathSum2 {
    /*
    //backtrack: DFS problem returning all possible solutions
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<>();
        List<Integer> currentResult  = new LinkedList<>();
        DFS(root,sum,currentResult,result);
        return result;
    }

    public void DFS(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        //base case
        if (root == null) {
            return;
        }
        //current action
        currentResult.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);
            return;
        } else {
            DFS(root.left, sum - root.val, currentResult, result);
            DFS(root.right, sum - root.val, currentResult, result);
            currentResult.remove(currentResult.size() - 1);
        }
    }

     */
}
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]

 */