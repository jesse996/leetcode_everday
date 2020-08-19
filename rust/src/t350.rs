// 给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
// 输出：[2,2]
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出：[4,9]
//
//
// 说明：
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
// 进阶：
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果nums1的大小比nums2小很多，哪种方法更优？
// 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

use std::collections::HashMap;

pub fn intersect(mut nums1: Vec<i32>, mut nums2: Vec<i32>) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in nums1.iter() {
        let count = map.entry(*i).or_insert(0);
        *count += 1;
    }
    let mut k = 0;
    for i in nums2.iter() {
        let count = map.entry(*i).or_insert(0);
        if *count > 0 {
            *count -= 1;
            nums1[k] = *i;
            k += 1;
        }
    }
    nums1[0..k].to_vec()
}

#[test]
fn test() {
    let num1 = vec![1, 2, 2,1];
    let num2 = vec![ 2, 2];
    let a=intersect(num1, num2);
    dbg!(&a);
}