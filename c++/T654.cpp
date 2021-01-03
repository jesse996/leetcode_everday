//
// Created by jesse on 2021/1/3.
//
#include <vector>

using std::vector;

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

    TreeNode *build(vector<int>& nums,int lo,int hi){
        if (lo > hi) {
            return nullptr;
        }
        int max = nums[lo];
        int index=lo;
        for (int i = lo; i <= hi; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        auto l=build(nums,lo,index-1);
        auto r = build(nums, index + 1, hi);
        auto root = new TreeNode(max, l, r);
        return root;
    }
    TreeNode *constructMaximumBinaryTree(vector<int> &nums) {
//        if (nums.empty()) {
//            return NULL;
//        }
//        auto max = std::max_element(nums.begin(), nums.end());
//        vector<int> left(nums.begin(), max);
//        vector<int> right(max + 1, nums.end());
//        auto l=constructMaximumBinaryTree(left);
//        auto r=constructMaximumBinaryTree(right);
//        auto root=new TreeNode(*max,l,r);
//        return root;
        return build(nums,0,nums.size()-1);
    }
};