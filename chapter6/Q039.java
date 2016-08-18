package chapter6;

/**
 * Created by Administrator on 2016/8/8. 二叉树的深度
 * 输入一棵二叉树的根结点，求该树的深度，从根结点到叶节点依次经过的结点（含根，叶节点）形成树的一条路径，最长路径的长度为树的深度
 */
public class Q039 {

    static class Node {
        int value;
        Node left;
        Node right;
    }

    /**
     * 二叉树的深度
     */
    private static int treeDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int nLeft = treeDepth(root.left);
        int nRight = treeDepth(root.right);
        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();

        a.left = b;
        a.right = c;
        b.left = d;
        d.left = e;

        System.out.println(treeDepth(a));
    }
}