package Recover;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RecoverBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode first, second, prev;

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

    static void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);
        if (first != null && second != null) {
            int t = first.val; first.val = second.val; second.val = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vals = sc.nextLine().split(" ");
        if (vals[0].equals("null")) return;

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < vals.length) {
            TreeNode cur = q.poll();
            if (!vals[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(cur.left);
            }
            i++;
            if (i < vals.length && !vals[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(cur.right);
            }
            i++;
        }

        recoverTree(root);
        printInorder(root);
    }

    static void printInorder(TreeNode r) {
        if (r == null) return;
        printInorder(r.left);
        System.out.print(r.val + " ");
        printInorder(r.right);
    }
}
