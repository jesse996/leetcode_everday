//
// Created by jesse on 2021/1/5.
//
//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//
//说明：
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    int rank=0;
    int res;
    int kthSmallest(TreeNode* root, int k) {
        inorder(root, k);
        return res;
    }

    void inorder(TreeNode *root,int k){
        if (!root) {
            return;
        }
        inorder(root->left);
        rank++;
        if (rank==k){
            res = root->val;
        }
        inorder(root->right);
    }
};