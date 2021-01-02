//
// Created by jesse on 2021/1/2.
//

#ifndef CPPPROJECT_T25_H
#define CPPPROJECT_T25_H

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class T25 {
    ListNode *reverseKGroup(ListNode *head, int k);
    ListNode * reverse(ListNode *a, ListNode *b);
};


#endif //CPPPROJECT_T25_H
