//
// Created by jesse on 2021/1/2.
//

#include <MacTypes.h>
#include "T25.h"

ListNode *reverse(ListNode *a, ListNode *b) {
    ListNode *pre = NULL, *curr = a, *next = a;
    while (curr != b) {
        next = curr->next;
        curr->next = pre;
        pre = curr;
        curr = next;
    }
    return pre;
}

ListNode *reverseKGroup(ListNode *head, int k) {
    ListNode *a = head, *b = head;
    for (int i = 0; i < k; ++i) {
        if (!b) {
            return a;
        }
        b = b->next;
    }
    reverse(a, b);
    a->next = reverseKGroup(b, k);
    return head;
}

