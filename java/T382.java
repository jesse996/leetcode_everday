import javax.swing.*;
import java.util.List;
import java.util.Random;

/**
 * @Author: jesse
 * @Date: 2021/1/31 1:39 下午
 * <p>
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * <p>
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T382 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode p = head;
            Random random = new Random();
            int res = 0, i = 0;
            while (p != null) {
                if (random.nextInt(++i) == 0) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */