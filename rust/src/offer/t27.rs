//请完成一个函数，输入一个二叉树，该函数输出它的镜像。

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

pub fn mirror_tree(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
    if root.is_none() { None } else {
        let root = root.unwrap();
        let l = mirror_tree(root.borrow_mut().left.take());
        let r = mirror_tree(root.borrow_mut().right.take());
        root.borrow_mut().left = r;
        root.borrow_mut().right = l;
        Some(root)
    }
}
