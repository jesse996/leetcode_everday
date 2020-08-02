package 剑指offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class T27 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        return root;
    }
}
