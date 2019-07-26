import java.util.HashMap;
import java.util.Map;

// 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

// 示例：

// 给定一个链表: 1->2->3->4->5, 和 n = 2.

// 当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 说明：

// 给定的 n 保证是有效的。

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;// 总数
    ListNode p = head;
    Map<Integer, ListNode> map = new HashMap<>();
    while (p != null) {
      map.put(count, p);
      p = p.next;
      count++;
    }
    ListNode curr = map.get(count - n);
    if (curr == head)
      return curr.next;
    ListNode pre = map.get(count - n - 1);
    pre.next = pre.next.next;
    return head;
  }
}