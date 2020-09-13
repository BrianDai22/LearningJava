import java.util.LinkedList;
import java.util.Queue;

public class DepthOfTree {
    public static int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSideRootPath = getDepth(root.left);
        int rightSideRootPath = getDepth(root.right);

        return Math.max(leftSideRootPath + 1, rightSideRootPath + 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(getDepth(root));
    }

}


      /*  Given a binary tree, find its maximum depth.


        Example:

        Given binary tree

           3  -- depth = 1
          / \
         9  20 -- depth = 2
        /    \
       15     7 -- depth = 3

        return its max depth = 3.
      */