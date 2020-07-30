package 剑指offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class T24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode(0);
        while (head != null) {
            ListNode tmp=head.next;
            head.next = h.next;
            h.next = head;
            head = tmp;
        }
        return h.next;
    }
}
