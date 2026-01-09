package Tree;

import java.util.*;

public class ZigZag {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (leftToRight) level.addLast(cur.val);
                else level.addFirst(cur.val);

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] v = sc.nextLine().split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(v[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < v.length) {
            TreeNode cur = q.poll();
            if (!v[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(v[i]));
                q.add(cur.left);
            }
            i++;
            if (i < v.length && !v[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(v[i]));
                q.add(cur.right);
            }
            i++;
        }

        System.out.println(zigzagLevelOrder(root));
    }
}
