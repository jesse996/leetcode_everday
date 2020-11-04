// 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//  
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
// 输出：[1,2] 或者 [2,1]
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
// 输出：[0]
//
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// use std::prelude::*;

pub fn get_least_numbers(mut arr: Vec<i32>, k: i32) -> Vec<i32> {
    if k == 0 { return vec![]; }
    arr.sort();
    let mut res=vec![];
    for i in 0..k {
        res.push(arr[i as usize]);
    }
    res
}

#[test]
fn test() {
    assert_eq!(get_least_numbers(vec![3, 2, 1], 2), vec![1, 2]);
    assert_eq!(get_least_numbers(vec![0, 1, 2, 1], 1), vec![0]);
    assert_eq!(get_least_numbers(vec![0, 1, 2, 1], 1), vec![0]);
    assert_eq!(get_least_numbers(vec![0, 0, 0, 2, 0, 5], 0), vec![]);
}
