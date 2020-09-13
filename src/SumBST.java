public class SumBST {

    public static int getSumBST(TreeNode root, int L, int R) {


        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(getSumBST(root, 7, 15));
    }

}
/*
        Given a binary search tree, return the sum between L and R (inclusive).


        Example 1:

        Input: root = [10,5,15,3,7,null,18], L = 7, R = 15

         10
        / \
       5   15
      / \    \
     3  7    18

        Output: 32

        */
