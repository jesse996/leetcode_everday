// 合并K个排序链表
// 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

// 示例:

// 输入:
// [
// 1->4->5,
// 1->3->4,
// 2->6
// ]
// 输出: 1->1->2->3->4->4->5->6

import java.util.Comparator;
import java.util.PriorityQueue;

//  * Definition for singly-linked list.定义
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//分治法，分成多个合并2个
public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        for (int i = 0; i < lists.length - mid; i++) {
            l2[i] = lists[i + mid];
        }
        return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        var dummy = new ListNode(-1);
        var p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (var list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (pq.size() != 0) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }

            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}

