package chapter4;

import java.util.ArrayList;

/**
 * Created by tc on 9/6/16.二叉树中和为某一值的路径
 * 输入一个二叉树和一个整数,打印出二叉树中节点值的和为输入的整数的所有路径,从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 * <p>
 * 例如
 * 10
 * 5       12
 * 4  7
 * <p>
 * 输入上述二叉树和整数 22,则打印出两条路径,第一条路径包含节点 10 -> 12,第二条路径包含节点 10 -> 5 -> 7
 */
public class Q025 {

    private static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode rootL = new TreeNode(5);
        TreeNode rootR = new TreeNode(12);
        TreeNode rootLL = new TreeNode(4);
        TreeNode rootLR = new TreeNode(7);

        root.left = rootL;
        root.right = rootR;
        rootL.left = rootLL;
        rootL.right = rootLR;

        findPath(root, 22);
    }

    private static void findPath(TreeNode root, int sum) {

        if (root == null) {
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int currentSum = 0;
        findPath(root, sum, path, currentSum);
    }


    /**
     * 用前序遍历的方式访问树,在一个节点,将该节点的值添加到路径中,并累加该节点的值,如果该节点为叶节点并且路径中节点值的和刚好等于输入的整数
     * 则当前路径符合要求,打印出来.
     *
     * 如果当前节点不是叶节点,则继续访问它的子节点
     *
     * 当前节点访问结束后,递归函数将自动回到它的父节点,因此在函数退出时要在路径中删除当前节点并减去当前节点的值
     */
    private static void findPath(TreeNode root, int sum, ArrayList<Integer> path, int currentSum) {
        currentSum += root.value;
        path.add(root.value);

        boolean isLeaf = root.left == null && root.right == null;

        if (currentSum == sum && isLeaf) {
            for (Integer i : path) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
        if (root.left != null) {
            findPath(root.left, sum, path, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, sum, path, currentSum);
        }
        path.remove(path.size() - 1);
    }
}
