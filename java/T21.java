/**
 * 合并两个有序链表
 * 
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode i = l1, j = l2, head,p, tmp;
    p=head=new ListNode(0);
    while (i != null && j != null) {
      if (i.val < j.val) {
        tmp = new ListNode(i.val);
        i = i.next;
      } else {
        tmp = new ListNode(j.val);
        j = j.next;
      }
      if (p != null) {
        p.next = tmp;
        p = p.next;
      } else {
        head = p = tmp;
      }
    }
    if (i != null) {
      p.next=i;
    }
    else  {
      p.next=j;
    }
    return head.next;
  }
}