//
// Created by jesse on 2021/1/5.
//
//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
//
//提醒一下，二叉搜索树满足下列约束条件：
//
//节点的左子树仅包含键 小于 节点键的节点。
//节点的右子树仅包含键 大于 节点键的节点。
//左右子树也必须是二叉搜索树。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
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
    int sum=0;
    TreeNode* convertBST(TreeNode* root) {
        inorder(root);
        return root;
    }

    void inorder(TreeNode *root){
        if (!root) {
            return;
        }
        inorder(root->right);
        sum += root->val;
        root->val = sum;
        inorder(root->left);
    }
};