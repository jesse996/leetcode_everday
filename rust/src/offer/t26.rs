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

pub fn is_sub_structure(a: Option<Rc<RefCell<TreeNode>>>, b: Option<Rc<RefCell<TreeNode>>>) -> bool {
    //use `a.as_ref().unwrap().take().left`  when take() is stable
    (a.is_some() && b.is_some()) && (rescue(&a, &b) || is_sub_structure(a.as_ref().unwrap().borrow().left.clone(), b.clone()) || is_sub_structure(a.as_ref().unwrap().borrow().right.clone(), b.clone()))
}

fn rescue(a: &Option<Rc<RefCell<TreeNode>>>, b: &Option<Rc<RefCell<TreeNode>>>) -> bool {
    if b.is_none() { true } else if a.is_none() || a.as_ref().unwrap().borrow().val != b.as_ref().unwrap().borrow().val { false } else {
        rescue(&a.as_ref().unwrap().borrow().left, &b.as_ref().unwrap().borrow().left) && rescue(&a.as_ref().unwrap().borrow().right, &b.as_ref().unwrap().borrow().right)
    }
}
