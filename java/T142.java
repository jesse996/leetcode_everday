import java.util.*;

// 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

// 说明：不允许修改给定的链表。

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

// 进阶：
// 你是否可以不用额外空间解决此题？

// 1.用map存

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        Set set = new HashSet<ListNode>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p))
                return p;
            set.add(p);
            p = p.next;
        }
        return null;
    }
}

// 2.用快慢指针
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCircle = false;
        // 判断是否有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast != null && fast == slow) {
                hasCircle = true;
                break;
            }
        }
        // 找出位置
        if (hasCircle) {
            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }
}