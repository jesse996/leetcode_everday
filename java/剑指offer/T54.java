package 剑指offer;

/**
 * @Author: jesse
 * @Date: 2021/1/23 5:13 下午
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class T54 {
    public int kthLargest(TreeNode root, int k) {
//        int right = size(root.right);
//        int rank = right + 1;
//        if (k == rank) {
//            return root.val;
//        } else if (k > rank) {
//            return kthLargest(root.left, k - rank);
//        } else if (k < rank) {
//            return kthLargest(root.right, k);
//        }
//        return -1;
        traverse(root, k);
        return res;
    }
    int count=0,res=0;
    public void traverse(TreeNode root,int k) {
        if (root==null) return;
        traverse(root.right,k);
        if (++count==k){
            res = root.val;
            return;
        }
        traverse(root.left,k);
    }

    private int size(TreeNode root) {
        if (root==null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
