import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzag {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println(zigzagLevelOrder(root));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        //DFS(root, list, 0);
        BFS(root, list, 0);
        return list;
    }

    private static void DFS(TreeNode curr, List<List<Integer>> list, int level) {
        //base case
        if(curr == null) {
            return;
        }
        //current action
        if(list.size() <= level)  {
            List<Integer> newLevel = new LinkedList<>();
            list.add(newLevel);
        }
        List<Integer> data  = list.get(level);
        if(level % 2 == 0) {
            data.add(curr.val);
        } else {
            data.add(0, curr.val);
        }
        //next action
        DFS(curr.left, list, level + 1);
        DFS(curr.right, list, level + 1);
    }
    private static void BFS(TreeNode root, List<List<Integer>> list, int level) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> data = new LinkedList<>();
            int currentLevelSize = q.size();
            for(int i = 0; i < currentLevelSize; i++) {
                TreeNode curr = q.poll();
                if(level % 2 == 0) {
                    data.add(0, curr.val);
                } else {
                    data.add(curr.val);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
            list.add(data);
            level++;
        }
    }
}
/*
return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
