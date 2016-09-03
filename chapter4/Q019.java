package chapter4;

/**
 * Created by tc on 9/3/16.二叉树的镜像
 * 请完成一个函数,输入一个二叉树,该函数输出它的镜像
 *
 * 例如:
 *       8                       8
 *   6      10     镜像:     10      6
 * 5  7    9  11          11  9    7  5
 *
 */
public class Q019 {

    private static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value=value;
            left=null;
            right=null;
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
        rootL.left = rootLL;
        rootL.right=rootLR;
        rootR.left=rootRL;
        rootR.right=rootRR;

        mirrorRecursively(root);

        System.out.println(root.left.left.value);

    }


    /**
     * 思路:
     *
     * 先序遍历(跟->左->右)二叉树,如果遍历到的节点有子节点,就交换它的两个子节点
     */
    private static void mirrorRecursively(TreeNode root){

        if (root==null){
            return;
        }

        if (root.left==null&&root.right==null){//如果两个子节点都为空,就返回
            return;
        }
        // 交换两个子节点
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        if (root.left!=null){
            mirrorRecursively(root.left);
        }
        if (root.right!=null){
            mirrorRecursively(root.right);
        }
    }




}
