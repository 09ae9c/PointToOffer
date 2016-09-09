package chapter4;

/**
 * Created by tc on 9/7/16.二叉搜索树与双向链表
 *
 * 输入一个二叉搜索树,将该二叉搜索树转换成一个排序的双向链表,要求不能创建任何新的节点,只能调整树中节点指针的指向
 * 例如:
 *        10
 *    6        14
 *  4  8     12  16
 *
 * 将转换成:
 * 4 <-> 6 <-> 8 <-> 10 <-> 12 <-> 14 <-> 16
 */
public class Q027 {

    private static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    public static void main(String[] args){

    }
}
