//
// Created by jesse on 2021/1/3.
//

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    bool isPalindrome(ListNode *head) {
        //get middle
        auto slow = head, fast = head;
        while (fast && fast->next) {
            fast = fast->next->next;
            slow = slow->next;
        }

        //reverse slow..end
        ListNode *pre = nullptr, *curr = slow;
        while (curr) {
            auto tmp = curr->next;
            curr->next = pre;
            pre = curr;
            curr = tmp;
        }

        //judge is palindrome
        auto left = head, right = pre;
        while (right) {
            if (right->val != left->val) {
                return false;
            }
            left = left->next;
            right = right->next;
        }
        return true;
    }
};