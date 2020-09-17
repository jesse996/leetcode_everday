//给定一个二叉树，判断其是否是一个有效的二叉搜索树。

public class T98 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //法一
//    public boolean isValidBST(TreeNode root) {
//        if (root==null) return true;
//        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
//    }
//
//    static boolean isBST(TreeNode node,int min,int max){
//        if (node==null) return true;
//        if (node.val>=max||node.val<=min) return false;
//        return isBST(node.left,min,node.val)&&isBST(node.right,node.val,max);
//    }

    //法二：中序遍历
    boolean res = true;
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (node.val <= pre) {
            res = false;
            return;
        }
        pre=node.val;
        inorder(node.right);
    }
}
