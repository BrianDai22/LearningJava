class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class Same_Tree {
    public static void main(String[] args) {
        /*
         *               1
         *              / \
         *           2      3
         *          / \    / \
         *         4   5  6   7
         * */
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        TreeNode n11 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);
        TreeNode n33 = new TreeNode(3);
        TreeNode n44 = new TreeNode(4);
        TreeNode n55 = new TreeNode(5);
        TreeNode n66 = new TreeNode(9);
        TreeNode n77 = new TreeNode(7);
        n11.left = n22;
        n11.right = n33;
        n22.left = n44;
        n22.right = n55;
        n33.left = n66;
        n33.right = n77;
        System.out.println(isSameTree(n1, n11)); // false
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. if p is null and q is null, what happen?

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
           return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);

        }
        // 4. if p.val not equals q.val, what happen?

        return false;


    }
}

