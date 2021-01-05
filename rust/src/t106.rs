// 根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
// 你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]
// 返回如下的二叉树：
//
// 3
// / \
// 9  20
// /  \
// 15   7
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
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
      right: None
    }
  }
}
use std::rc::Rc;
use std::cell::RefCell;
struct Solution;

impl Solution {
    pub fn build_tree(inorder: Vec<i32>, postorder: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        Self::build(&inorder,0,inorder.len() as i32-1,&postorder,0,postorder.len() as i32-1)
    }
    pub fn build(inorder: &Vec<i32>, in_start: i32, in_end: i32, postorder: &Vec<i32>, post_start: i32, post_end: i32) -> Option<Rc<RefCell<TreeNode>>> {
        if post_start > post_end {
            return None;
        };
        let root_value = postorder[post_end as usize];
        let index = inorder.iter().position(|&x| x == root_value).unwrap() as i32;
        let left_size=index-in_start;
        let left = Self::build(inorder, in_start, index - 1, postorder, post_start, post_start + left_size - 1);
        let right = Self::build(inorder, index + 1, in_end, postorder, post_start + left_size, post_end - 1);
        Some(Rc::new(RefCell::new(TreeNode{
            val:root_value,
            left,
            right
        })))
    }
}