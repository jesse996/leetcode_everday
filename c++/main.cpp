//
// Created by jesse on 2021/1/2.
//

#include <iostream>
#include "T234.cpp"

using namespace std;

int main() {
    Solution solution;
    ListNode head = ListNode(1);
    ListNode p1 = ListNode(2);
//    ListNode p2 = ListNode(3);
    ListNode p3 = ListNode(2);
    ListNode p4 = ListNode(1);
    head.next = &p1;
//    p1.next = &p2;
//    p2.next = &p3;
    p1.next = &p3;
    p3.next = &p4;

    cout << solution.isPalindrome(&head) << endl;

    return 0;
}
