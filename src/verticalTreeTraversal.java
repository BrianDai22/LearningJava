import java.util.*;

class QueueNode {
    TreeNode node;
    int col;
    public QueueNode(TreeNode node, int col)  {
        this.node = node;
        this.col = col;
    }
}

public class verticalTreeTraversal {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> verticalTraverseDFS(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        DFS(root, 0, 0, map);
        List<List<Integer>> answer = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> row: map.values()) {
            answer.add(new ArrayList<>());
            for(PriorityQueue<Integer> insideRow: row.values()) {
                while(!insideRow.isEmpty()) {
                    answer.get(answer.size()-1).add(insideRow.peek());
                }
            }
        }
        return answer;
    }
    public static List<List<Integer>> verticalTraverseBFS(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        BFS(root, map);
        return new ArrayList<>(map.values());
    }

    public static void DFS(TreeNode root, int col_id, int row_id, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        //when can I stop?
        if (root == null) {
            return;
        }
        //what should I do in current case?
        //save the current value into correct position in the map
        if (!map.containsKey(col_id)) {
            map.put(col_id, new TreeMap<>());
        }
        if (!map.get(col_id).containsKey(row_id)) {
            map.get(col_id).put(row_id, new PriorityQueue<>());
        }
        map.get(col_id).get(row_id).add(root.val);
        //what should I do in next state?
        DFS(root.left, col_id - 1, row_id + 1, map);
        DFS(root.right, col_id + 1, row_id + 1, map);
    }

    public static void BFS(TreeNode root, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null) {
            return;
        }

        Queue<QueueNode> q = new LinkedList<>();
        q.offer(new QueueNode(root, 0));

        while (!q.isEmpty()) {
            QueueNode cur = q.poll();
            TreeNode node = cur.node;
            int order = cur.col;

            ArrayList<Integer> list = map.get(order);
            map.computeIfAbsent(order, key -> new ArrayList<>());
            list.add(node.val);

            if (node.left != null) {
                q.offer(new QueueNode(node.left, order-1));
            }

            if (node.right != null) {
                q.offer(new QueueNode(node.right, order+1));
            }
        }
    }
}

