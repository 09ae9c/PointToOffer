package chapter4;

import java.util.Arrays;

/**
 * Created by tc on 9/6/16.二叉搜索树的后序遍历序列
 * 输入一个整数数组,判断该数组是不是某二叉搜索树的后序遍历结果,如果是则返回 true,否则返回 false
 * 例如:
 * 8
 * 6       10
 * 5   7   9    11
 * <p>
 * 输入数组 {5,7,6,9,11,10,8} 则返回 true,因为这个整数序列是上面二叉树的后序遍历结果
 * 如果输入数组 {7,4,6,5} 由于没有哪个二叉树的后续遍历的结果是这个序列,因此返回 false
 */
public class Q024 {

    public static void main(String[] args) {

        int[] rightOrder = {5, 7, 6, 9, 11, 10, 8};
        int[] wrongOrder = {7, 4, 6, 5};

        System.out.println(verifySequenceOfBST(rightOrder));
        System.out.println(verifySequenceOfBST(wrongOrder));
    }

    /**
     * 思路
     *
     * 在后序遍历序列中,最后一个数是二叉搜索树的根节点,数组前面部分可以分成两部分:
     * 第一部分是根节点的左子树,它们的值都小于根节点,第二部分是根节点的右子树,它们的值都大于根节点
     * 例如序列 {5,7,6,9,11,10,8} 中,8 是根节点的值,前面的部分分成左子树 {5,7,6} 和右子树 {9,11,10},满足上述的条件
     * 接下来在左子树 {5,7,6} 中继续进行上述的划分,可以知道 6 是节点,5 是 6 的左子树,7 是 6 的右子树
     * 通过这种递归的遍历,就能判断一个序列是不是二叉搜索树的后序遍历序列
     */
    private static boolean verifySequenceOfBST(int[] seq) {

        if (seq == null || seq.length == 0) {
            return false;
        }

        int length = seq.length;
        int root = seq[length - 1];

        //二叉树搜索树中左子树的节点小于根节点
        int mid = 0;
        for (int i = 0; i < length; i++) {
            if (seq[i] > root) {
                mid = i;
                break;
            }
        }

        //二叉搜索树中右子树的节点大于根节点,如果在这部分中存在小于根节点的节点,则说明这个序列是错误的
        for (int j = mid; j < length; j++) {
            if (seq[j] < root) {
                return false;
            }
        }

        //将数组切分成左右两个子数组
        int[] leftSeq = Arrays.copyOfRange(seq, 0, mid);
        int[] rightSeq = Arrays.copyOfRange(seq, mid, length - 1);

        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (mid > 0) {
            left = verifySequenceOfBST(leftSeq);
        }

        //判断右子树是不是二叉搜索树
        boolean right = true;
        if (mid < length - 1) {
            right = verifySequenceOfBST(rightSeq);
        }
        return left && right;
    }
}
