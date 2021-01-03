//
// Created by jesse on 2021/1/3.
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//struct Node {
//    int val;
//    Node *left;
//    Node *right;
//    Node *next;
//}
//        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//初始状态下，所有 next 指针都被设置为 NULL。
//
// 
//
//进阶：
//
//你只能使用常量级额外空间。
//使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//

#include <MacTypes.h>

class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution {
public:
    void connectTwoNode(Node *left, Node *right) {
        if (!left||!right) return;
        left->next=right;
        connectTwoNode(left->left, left->right);
        connectTwoNode(right->left, right->right);
        connectTwoNode(left->right, right->left);
    }

    Node* connect(Node* root) {
        if (!root) {
            return root;
        }
        connectTwoNode(root->left,root->right);
        return root;
    }
};