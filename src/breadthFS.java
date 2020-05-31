import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class breadthFS {
    /*
    Given a binary tree, return the level order traversal of values. (ie, from left to right, level by level).


    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7

            return its level order traversal as:
            [
            [3],
            [9,20],
            [15,7]
            ]


    init code:
            --------------------------------------------------------
    */
    public static class BinaryTreeLevelOrder {
        public static List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) {
                return result;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // TODO: loop the queue and perform BFS

            while(!q.isEmpty()) {
                root = q.poll();
                List<Integer> curResult = new ArrayList<>();
                int curLevel = q.size();
                for(int i=0; i<curLevel; ++i) {
                    // 1. dequeue 1st node N in queue
                    TreeNode cur = q.remove();
                    // 2. add the value of N into curResult
                    curResult.add(cur.val);
                    // 3. check any child exist for the node N, if exist, add into queue
                    if (cur.left != null) {
                        q.add(cur.left);
                    }
                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }

                result.add(curResult);

            }
            return result;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            TreeNode n1 = new TreeNode(9);
            TreeNode n2 = new TreeNode(20);
            TreeNode n3 = new TreeNode(15);
            TreeNode n4 = new TreeNode(7);
            root.left = n1;
            root.right = n2;
            n1.left = null;
            n1.right = null;
            n2.left = n3;
            n2.right = n4;
            n3.left = null;
            n3.right = null;
            n4.left = null;
            n4.right = null;

            System.out.println(levelOrder(root));
        }
    }
}
