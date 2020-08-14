package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i =queue.size();i>0;i--){
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ret.add(list);
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
