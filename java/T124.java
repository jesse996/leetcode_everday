// 给定一个非空二叉树，返回其最大路径和。

// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

// 示例 1:

// 输入: [1,2,3]

//        1
//       / \
//      2   3

// 输出: 6
// 示例 2:

// 输入: [-10,9,20,null,null,15,7]

//    -10
//    / \
//   9  20
//     /  \
//    15   7

// 输出: 42

//  Definition for a binary tree node. 

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class T124_1 {
    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return ret;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, max(root.left));
        int right = Math.max(0, max(root.right));
        ret = Math.max(ret, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}

public class T124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new T124_1().maxPathSum(root));
    }
}