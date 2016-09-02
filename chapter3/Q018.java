package chapter3;

/**
 * Created by tc on 9/1/16.树的子结构
 * 输入两棵二叉树 A 和 B,判断 B 是不是 A 的子结构
 */
public class Q018 {
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

        TreeNode rootA = new TreeNode(8);
        TreeNode rootAL = new TreeNode(8);
        TreeNode rootAR = new TreeNode(7);
        TreeNode rootALL = new TreeNode(9);
        TreeNode rootALR = new TreeNode(2);
        TreeNode rootALRL = new TreeNode(4);
        TreeNode rootALRR = new TreeNode(7);

        rootA.left = rootAL;
        rootA.right = rootAR;
        rootAL.left = rootALL;
        rootAL.right = rootALR;
        rootALR.left = rootALRL;
        rootALR.right = rootALRR;


        TreeNode rootB = new TreeNode(8);
        TreeNode rootBL = new TreeNode(9);
        TreeNode rootBR = new TreeNode(2);

        rootB.left = rootBL;
        rootB.right = rootBR;


        System.out.println(hasSubTree(rootA, rootB));
    }


    /**
     *判断 rootB 是不是 rootA 的子树
     * 首先在 root A 中遍历节点,如果找到某一个节点的值和 rootB 的根节点值相等,则执行 doesTreeAHasTreeB() 方法
     *
     */
    private static boolean hasSubTree(TreeNode rootA, TreeNode rootB) {

        boolean result = false;
        if (rootA != null && rootB != null) {

            if (rootA.value == rootB.value) {
                result = doesTreeAHasTreeB(rootA, rootB);
            }
            if (!result) {
                result = hasSubTree(rootA.left, rootB);
            }
            if (!result) {
                result = hasSubTree(rootA.right, rootB);
            }
        }
        return result;
    }

    /**
     *
     * 判断 rootA 中是否包含 rootB
     * 此时,rootA 的根节点值和 rootB 的根节点值相等,分别比较 rootA 与 root B 对应的子节点是否相等
     */
    private static boolean doesTreeAHasTreeB(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) {
            return true;
        }
        if (rootA == null) {
            return false;
        }

        if (rootA.value != rootB.value) {
            return false;
        }
        return doesTreeAHasTreeB(rootA.left, rootB.left) && doesTreeAHasTreeB(rootA.right, rootB.right);
    }
}
