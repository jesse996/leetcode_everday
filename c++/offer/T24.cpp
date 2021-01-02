//
// Created by jesse on 2021/1/2.
//


#include <cstring>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *reverseList(ListNode *head) {
//        if (!head) return NULL;
//        if (head->next==NULL) {
//            return head;
//        }
//        ListNode * last = reverseList(head->next);
//        head->next->next = head;
//        head->next = NULL;
//        return last;
        ListNode *pre = NULL, *curr = head, *next = head;
        while (!curr) {
            next=curr->next;
            curr->next=pre;
            curr=next;
            pre=curr;
        }
        return pre;
    }
};