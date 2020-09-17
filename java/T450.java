import javax.swing.*;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T450 {
    class TreeNode {
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

    //一：删除后继节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                TreeNode next = root.right;
                while (next.left != null) {
                    next = next.left;
                }
                root.val=next.val;
                root.right=deleteMin(root.right);
            }
        }
        return root;
    }

    public TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            TreeNode r = node.right;
            node.right = null;
            return r;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    //二：删除前驱节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.right==null)
            root=root.left;
        if (root.left==null)
            root=root.right;

        TreeNode pre=root.left;
        while (pre.right!=null)
            pre=pre.right;
        root.val=pre.val;
        root.left=deleteMax(root.left);

        return root;

    }
    public TreeNode deleteMax(TreeNode node){
        if (node.right==null)
            return node.left;
        node.right=deleteMax(node.right);
        return node;
    }

}
