package 剑指offer;

import java.util.*;

/**
 * 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 *
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * ```
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ```
 *
 * 返回：
 *
 * [3,9,20,15,7]
 */
public class T32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new ArrayDeque<>() {{
            add(root);
        }};
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
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
