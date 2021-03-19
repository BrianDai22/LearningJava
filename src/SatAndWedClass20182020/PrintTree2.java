package SatAndWedClass20182020;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree2 {
    /*
    public static void printTree(TreeNode root){
        Queue<TreeNode> level  = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            TreeNode node = level.poll();
            System.out.print(node.val + " ");
            if(node.left!= null) {
                level.add(node.left);
            }
            if(node.right!= null) {
                level.add(node.right);
            }
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

     */
}

/*

    print following tree:

         1
        / \
       2   3
      / \ / \
     4  5 6  7

     as [1, 2, 3, 4, 5, 6, 7]

    Which always print tree level by level order
*/