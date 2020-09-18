/**
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。返回移除了所有不包含 1 的子树的原二叉树。( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 */
public class T841 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root==null) return null;
        root.left=pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left==null&&root.right==null&&root.val==0) return null;
        return root;
    }
}
