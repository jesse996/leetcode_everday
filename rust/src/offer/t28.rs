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

pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
    if root.is_none() { true } else {
        recur(root.as_ref().unwrap().borrow_mut().left.take(), root.as_ref().unwrap().borrow_mut().right.take())
    }
}

fn recur(l: Option<Rc<RefCell<TreeNode>>>, r: Option<Rc<RefCell<TreeNode>>>) -> bool {
    if l.is_none() && r.is_none() { true } else if l.is_none() || r.is_none() || l.as_ref().unwrap().borrow().val != r.as_ref().unwrap().borrow().val {
        false
    } else {
        recur(l.as_ref().unwrap().borrow_mut().left.take(), r.as_ref().unwrap().borrow_mut().right.take())
            && recur(l.as_ref().unwrap().borrow_mut().right.take(), r.as_ref().unwrap().borrow_mut().left.take())
    }
}
