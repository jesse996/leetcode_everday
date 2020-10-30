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
use std::collections::LinkedList;


pub fn path_sum(root: Option<Rc<RefCell<TreeNode>>>, sum: i32) -> Vec<Vec<i32>> {
    let mut res:Vec<Vec<i32>>=vec![];
    let mut path:Vec<i32>=vec![];
    recur(&root,sum,&mut res,&mut path);
    res
}
fn recur(mut node:&Option<Rc<RefCell<TreeNode>>>,mut sum:i32,res:&mut Vec<Vec<i32>>,path:&mut Vec<i32>){
    if let None=node{
        return;
    }else {
        let node=node.as_ref().unwrap();
        path.push(node.borrow().val);
        sum-=node.borrow().val;
        if sum==0&&node.borrow().left.is_none()&&node.borrow().right.is_none() {
            res.push(path.clone());
        }
        recur(&node.borrow().left,sum,res,path);
        recur(&node.borrow().right,sum,res,path);
        path.pop();
    }
}