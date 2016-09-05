package chapter4;

import structure.Queue;

/**
 * Created by tc on 9/5/16. 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点,同一层的节点按照从左往右的顺序打印
 * 例如:
 *        8
 *     6    10
 *   5  7  9  11
 *
 * 则依次打印出:8,6,10,5,7,9,11
 */
public class Q023 {
    private static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode rootL = new TreeNode(6);
        TreeNode rootR = new TreeNode(10);
        TreeNode rootLL = new TreeNode(5);
        TreeNode rootLR = new TreeNode(7);
        TreeNode rootRL = new TreeNode(9);
        TreeNode rootRR = new TreeNode(11);

        root.left=rootL;
        root.right=rootR;
        rootL.left=rootLL;
        rootL.right=rootLR;
        rootR.left=rootRL;
        rootR.right=rootRR;

        printTreeFromTopToBottom(root);

    }


    /**
     * 思路:
     * 每一次打印一个结点的时候，如果该结点有子节点，把该结点的子节点放到一个队列的尾。
     * 接下来到队列的头部取出最早进入队列的结点，重复前面打印操作，直到队列中所有的结点都被打印出为止。
     */
    private static void printTreeFromTopToBottom(TreeNode root){
        if (root==null){
            return;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.dequeue();
            System.out.println(treeNode.value);
            if (treeNode.left!=null){
                queue.enqueue(treeNode.left);
            }
            if (treeNode.right!=null){
                queue.enqueue(treeNode.right);
            }
        }
    }
}
