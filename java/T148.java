// 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

// 示例 1:

// 输入: 4->2->1->3
// 输出: 1->2->3->4
// 示例 2:

// 输入: -1->5->3->4->0
// 输出: -1->0->3->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class ListNode {
//  int val;
//  ListNode next;
//
//  ListNode(int x) {
//    val = x;
//  }
//}

class T148 {
  public ListNode sortList(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    ListNode fast = head, slow = head, pre = null;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      pre = slow;
      slow = slow.next;
    }
    pre.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(slow);
    return merge(left, right);
  }

  public ListNode merge(ListNode l, ListNode r) {
    ListNode p = new ListNode(0), head = p;
    while (l != null && r != null) {
      if (l.val < r.val) {
        p.next = l;
        l = l.next;
      } else {
        p.next = r;
        r = r.next;
      }
      p = p.next;
    }
    if (l != null) {
      p.next = l;
    }
    if (r != null) {
      p.next = r;
    }
    return head.next;
  }
}