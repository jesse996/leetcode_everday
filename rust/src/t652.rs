// 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
// 1
// / \
// 2   3
// /   / \
// 4   2   4
// /
// 4
// 下面是两个重复的子树：
//
// 2
// /
// 4
// 和
//
// 4
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
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
use std::collections::HashMap;

struct Solution;

impl Solution {
    pub fn find_duplicate_subtrees(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Option<Rc<RefCell<TreeNode>>>> {
        let mut memo: HashMap<String,usize> = HashMap::new();
        let mut res=vec![];
        Self::traverse(root.as_ref(), &mut memo, &mut res);
        res
    }
    pub fn traverse(root: Option<&Rc<RefCell<TreeNode>>>, memo: &mut HashMap<String,usize>, res: &mut Vec<Option<Rc<RefCell<TreeNode>>>>) -> String {
        if  root.is_none() {
            return "#".to_string();
        }
        let root=root.unwrap();
        let mut left = Self::traverse(root.borrow().left.as_ref(), memo, res);
        let right = Self::traverse(root.borrow().right.as_ref(), memo, res);
        let s = left + "," + &*right + "," + &*root.borrow().val.to_string();
        let freq = memo.entry(s.clone()).or_default();
        if *freq==1{
            res.push(Some(Rc::clone(root)));
        }
        *freq+=1;
        s
    }
}