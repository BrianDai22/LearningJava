package SatAndWedClass20182020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightTree {
    /*
    public static List<Integer> printRightTree(TreeNode root) {
        /*
        List<TreeNode> rightSide = new LinkedList<>();
        List<TreeNode> leftSide = new LinkedList<>();
        rightSide.add(root);
        leftSide.add(root);

        if(root != null) {
            leftSide.add(printRightTree(root.left));
            System.out.print(root.val + " ");
            printRightTree(root.right);
        }

        if(rightSide.size() > leftSide.size()) {
            for(TreeNode x: rightSide) {
                System.out.println(x);
            }
        } else {
            int index = 0;
            for(TreeNode x: rightSide) {
                index++;
                System.out.println(x);
            }
            for(int i = index; i < leftSide.size(); i++) {
                System.out.println(leftSide.get(i));
            }
        }
         */

    /*
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode currentNode = null;
            for (int i = queue.size(); i > 0; i--) {
                currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentNode.val);
        }
        return result;
    }




    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;
        System.out.println(printRightTree(n1));
    }

     */
}


  /*
        Given a binary tree, if you are on the right side of it,
        return the values of the nodes you can see ordered from top to bottom.

        Example:

        Binary tree as below:
          1            <---
        /   \
        2     3         <---
        \     \
        5     4       <---
       /
      9     <--
        Output: [1, 3, 4, 9]
*/