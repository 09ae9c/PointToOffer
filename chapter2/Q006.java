package pointToOffer.chapter2;

import java.util.Arrays;

/**
 * Created by tc on 2016/8/18.重建二叉树
 * 已知二叉树前序遍历结果和中序遍历结果，求二叉树
 */
public class Q006 {

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        Node root = rebuild(preOrder, inOrder);
        System.out.println(root.value);
    }

    private static Node rebuild(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }
        Node root = new Node(preOrder[0]);

        int inOrderIndex = 0;
        while (inOrder[inOrderIndex] != root.value) {//得到中序中根节点的索引
            inOrderIndex++;
        }

        //将中序数组按照根节点的位置分成左右两部分
        int[] inLeft = Arrays.copyOfRange(inOrder, 0, inOrderIndex);
        int[] inRight = Arrays.copyOfRange(inOrder, inOrderIndex + 1, inOrder.length);

        //分别重构左右子树
        root.left = rebuild(Arrays.copyOfRange(preOrder, 1, inLeft.length + 1), inLeft);
        root.right = rebuild(Arrays.copyOfRange(preOrder, inOrderIndex + 1, preOrder.length), inRight);

        return root;
    }

}
