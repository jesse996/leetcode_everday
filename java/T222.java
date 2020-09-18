/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2^h个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T222 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //将完全二叉树拆为一个满二叉树和另一个完全二叉树
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if (leftLevel == rightLevel) return (1 << leftLevel) + countNodes(root.right);
        else return (1 << rightLevel) + countNodes(root.left);
    }

    public int countLevel(TreeNode node) {
        int level = 0;
        while (node != null) {
            level += 1;
            node = node.left;
        }
        return level;
    }


}
