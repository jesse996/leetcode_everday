// 编写一个程序，找到两个单链表相交的起始节点。

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// 1.暴力法，n方
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        for (; p != null; p = p.next) {
            ListNode q = headB;
            for (; q != null; q = q.next) {
                if (q == p) {
                    return q;
                }
            }
        }
        return null;
    }
}

// 2. O（n）
class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;

    }
}