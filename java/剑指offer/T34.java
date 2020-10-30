package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * <p>
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by jesse on 2020/10/30 下午9:22
 */
public class T34 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> res=new LinkedList<>();;
    private LinkedList<Integer> path=new LinkedList<>();;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    public void recur(TreeNode node, int sum) {
        if (node == null) return;
        path.add(node.val);
        sum-=node.val;
        if (sum==0&&node.left==null&&node.right==null){
            res.add(new LinkedList<>(path));
        }
        recur(node.left, sum);
        recur(node.right,sum);
        path.removeLast();
    }
}
