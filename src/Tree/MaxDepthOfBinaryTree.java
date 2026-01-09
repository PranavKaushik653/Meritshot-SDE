package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxDepthOfBinaryTree {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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

        System.out.println(maxDepth(root));
    }
}
