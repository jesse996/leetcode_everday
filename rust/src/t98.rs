// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

use std::rc::Rc;
use std::cell::RefCell;
use std::option::Option::Some;

struct Solution;

impl Solution {
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        Self::traverse(&root, &None, &None)
    }
    pub fn traverse(root: &Option<Rc<RefCell<TreeNode>>>, min: &Option<Rc<RefCell<TreeNode>>>, max: &Option<Rc<RefCell<TreeNode>>>) -> bool {
        if root.is_none() {
            return true;
        }
        let root = root.as_ref().unwrap();

        if let Some(m)=min{
            if m.borrow().val>=root.borrow().val{
                return false;
            }
        }
        if let Some(m)=max{
            if m.borrow().val<=root.borrow().val{
                return false;
            }
        }
        Self::traverse(&root.borrow().left, min, &Some(Rc::clone(&root))) && Self::traverse(&root.borrow().right, &Some(Rc::clone(&root)), max)
    }
}