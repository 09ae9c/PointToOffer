package chapter2;

import java.util.Arrays;

/**
 * Created by tc on 2016/8/18.重建二叉树
 * 已知二叉树前序遍历结果和中序遍历，求这个二叉树
 * 前序遍历：根->左->右
 * 中序遍历：左->根->右
 * 后序遍历：左->右->根
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

    /**
     * 思路：在前序遍历中，第一个元素是根结点，这个元素在中序遍历中的位置，左边就是根结点左边的所有元素，右边是根结点右边的所有元素
     * 例如 前序遍历的第一个元素是 1，则对应到中序遍历，在 1 左边的所有元素一定是在根结点左边，在 1 右边的所有元素一定是在根结点右边
     * 利用这个思路通过递归的方式就能得到整个二叉树
     * @param preOrder 前序遍历序列
     * @param inOrder 中序遍历序列
     * @return 二叉树根结点
     */
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