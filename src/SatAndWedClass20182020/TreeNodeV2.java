package SatAndWedClass20182020;

public class TreeNodeV2 {
    /*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    For example, this binary tree is symmetric:
            1
            / \
           2   2
          / \ / \
         3  4 4  3

    But the following is not:
            1
           / \
          2   2
           \   \
           3    3

     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public boolean isMirrorTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return false;
        }

        // 2. if one is null but another is not, what happen?

        if(p == null) {
            return false;
        }

        if(q == null) {
            return false;
        }

        // 3. if p.val equals q.val, what happen?

        if(p.val == q.val){
            return helper(p.left, q.right) && helper(p.right,q.left);

        }

        return false;
    }
}
