/**
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

 

示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    /
     2  0
       \
        1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
use std::cell::RefCell;
use std::rc::Rc;
use std::process::exit;
use std::panic::resume_unwind;

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

pub fn construct_maximum_binary_tree(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
    build(&nums,0,nums.len()-1)
}

pub fn build(nums: &Vec<i32>, start: usize, end: usize)->Option<Rc<RefCell<TreeNode>>> {
    //find max and index
    if start > end{
        return None;
    }
    let mut max = i32::min_value();
    let mut index = 0usize;
    for (i, &num) in nums[start..=end].iter().enumerate() {
        if num > max {
            max = num;
            index = i;
        };
    }
    let mut root = TreeNode::new(max);
    let left = build(nums, start, index - 1);
    let right = build(nums, index + 1, end);
    root.left=left;
    root.right=right;
    Some(Rc::new(RefCell::new(root)))
}
