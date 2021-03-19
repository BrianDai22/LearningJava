package SatAndWedClass20182020;

public class PrintTree1 {
    public static void printTree(TreeNode root){
        if(root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        printTree(root);
    }
}

/*

    print following tree:

         1
        / \
       2   3
      / \ / \
     4  5 6  7

        as [4, 2, 5, 1, 6, 3, 7]

        Which always print "left child - parent - right child" order
*/