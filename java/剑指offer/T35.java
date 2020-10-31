package 剑指offer;

import java.util.*;

/**
 * Created by jesse on 2020/10/31 下午4:28
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T35 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Map<Node, Node> visited = new HashMap();
    public Node copyRandomList(Node head) {
        return dfs(head);
    }
    public Node dfs(Node node){
        if (node==null) return null;
        if (visited.get(node)!=null){
            return visited.get(node);
        }
        Node copy = new Node(node.val);
        visited.put(node, copy);
        copy.next = dfs(node.next);
        copy.random = dfs(node.random);
        return copy;
    }

    public Node bfs(Node node){
        if (node==null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        Node copy = new Node(node.val);
        queue.add(node);
        visited.put(node, copy);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if (tmp.next!=null&&visited.get(tmp.next) == null) {
                visited.put(tmp.next, new Node(tmp.next.val));
                queue.add(tmp.next);
            }
            if (tmp.random != null && visited.get(tmp.random) == null) {
                visited.put(tmp.random, new Node(tmp.random.val));
                queue.add(tmp.random);
            }
            visited.get(tmp).next = visited.get(tmp.next);
            visited.get(tmp).random = visited.get(tmp.random);
        }
        return copy;
    }
    public Node copyRandomList2(Node head) {
        if (head==null) return null;
        Node oldNode = head, newNode = new Node(head.val);
        visited.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visited.get(head);
    }

    private Node getClonedNode(Node node) {
        if (node==null) return null;
        if (visited.get(node)==null) {
            visited.put(node, new Node(node.val));
        }
        return visited.get(node);
    }
}
