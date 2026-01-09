package SerializeDeserialize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SerializeDeserialize {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) {
                sb.append("null ");
            } else {
                sb.append(n.val).append(" ");
                q.add(n.left);
                q.add(n.right);
            }
        }
        return sb.toString().trim();
    }

    static TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] a = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < a.length) {
            TreeNode cur = q.poll();
            if (!a[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(a[i]));
                q.add(cur.left);
            }
            i++;
            if (i < a.length && !a[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(a[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        TreeNode root = deserialize(line);
        System.out.println(serialize(root));
    }
}
