/**
 * Created by jesse on 2021/2/8 下午2:45
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class T24 {
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

    public ListNode swapPairs(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        ListNode newHead = head.next;
        ListNode successor = head.next.next;
        head.next.next=head;
        head.next = swapPairs(successor);
        return newHead;
    }

}
