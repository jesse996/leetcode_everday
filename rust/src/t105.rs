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

struct Solution;

impl Solution {
    pub fn build_tree(preorder: Vec<i32>, inorder: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        Self::build(&preorder, 0, preorder.len() as i32 - 1, &inorder, 0, inorder.len() as i32 - 1)
    }
    pub fn build(preorder: &Vec<i32>, plo: i32, phi: i32, inorder: &Vec<i32>, ilo: i32, ihi: i32) -> Option<Rc<RefCell<TreeNode>>> {
        if plo > phi {
            return None;
        }
        let root_val = preorder[plo as usize];
        let index = inorder.iter().position(|&x| x == root_val).unwrap() as i32;
        let left_size = index - ilo;
        let left = Self::build(preorder, plo + 1, plo + left_size, inorder, ilo, index - 1);
        let right = Self::build(preorder, plo + left_size + 1, phi, inorder, index + 1, ihi);
        Some(Rc::new(RefCell::new(TreeNode {
            val: root_val,
            left,
            right,
        })))
    }
}