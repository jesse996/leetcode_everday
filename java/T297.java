import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @Author: jesse
 * @Date: 2021/1/7 5:44 下午
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //1.前序：
//    public String serialize(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        serialize(root, sb);
//        return sb.toString();
//    }
//
//    public void serialize(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            sb.append("#,");
//            return;
//        }
//        sb.append(root.val).append(",");
//        serialize(root.left, sb);
//        serialize(root.right, sb);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        List<String> list = Arrays.stream(data.split(",")).collect(Collectors.toList());
//        return deserialize(list);
//    }
//
//    private TreeNode deserialize(List<String> list) {
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        String first = list.remove(0);
//        if ("#".equals(first)) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(first));
//        root.left = deserialize(list);
//        root.right = deserialize(list);
//        return root;
//    }

    //2。后序
//    public String serialize(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        serialize(root, sb);
//        return sb.toString();
//    }
//
//    public void serialize(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            sb.append("#,");
//            return;
//        }
//        serialize(root.left, sb);
//        serialize(root.right, sb);
//        sb.append(root.val).append(",");
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        List<String> list = Arrays.stream(data.split(",")).collect(Collectors.toList());
//        return deserialize(list);
//    }
//
//    private TreeNode deserialize(List<String> list) {
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        String last = list.remove(list.size()-1);
//        if ("#".equals(last)) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(last));
//        root.right = deserialize(list);
//        root.left = deserialize(list);
//        return root;
//    }

    //3.层次遍历
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "#,";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.stream(data.split(",")).collect(Collectors.toList());
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String first = list.get(0);
        if ("#".equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < list.size(); ) {
            TreeNode node = queue.poll();
            String left = list.get(i++);
            String right = list.get(i++);
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }
        }
        return root;
    }
}
