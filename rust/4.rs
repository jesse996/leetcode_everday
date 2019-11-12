// 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

// 你可以假设 nums1 和 nums2 不会同时为空。

// 示例 1:

// nums1 = [1, 3]
// nums2 = [2]

// 则中位数是 2.0
// 示例 2:

// nums1 = [1, 2]
// nums2 = [3, 4]

// 则中位数是 (2 + 3)/2 = 2.5
pub fn find_median_sorted_arrays(mut nums1: Vec<i32>, mut nums2: Vec<i32>) -> f64 {
    let mut m = nums1.len();
    let mut n = nums2.len();
    if m > n {
        let tmp = nums1;
        nums1 = nums2;
        nums2 = tmp;
        let tmp = m;
        m = n;
        n = tmp;
    }
    let mut imin = 0;
    let mut imax = m;
    while imin <= imax {
        let i = (imin + imax) / 2;
        let j = (n + m + 1) / 2 - i;
        if i < imax && nums2[j - 1] > nums1[i] {
            imin = i + 1;
        } else if i > imin && nums1[i - 1] > nums2[j] {
            imax = i - 1;
        } else {
            let max_left;
            if i == 0 {
                max_left = nums2[j - 1];
            } else if j == 0 {
                max_left = nums1[i - 1];
            } else {
                max_left = std::cmp::max(nums1[i - 1], nums2[j - 1]);
            }
            if (m + n) % 2 != 0 {
                return max_left as f64;
            }
            let min_right;
            if i == m {
                min_right = nums2[j];
            } else if j == n {
                min_right = nums1[i];
            } else {
                min_right = std::cmp::min(nums1[i], nums2[j])
            }
            println!("max_left={}", max_left);
            println!("right={}", min_right);
            return (max_left + min_right) as f64 / 2.0;
        }
    }
    0.0
}

fn main() {
    let nums1 = vec![1, 2];
    let nums2 = vec![1, 2, 3];

    let s = find_median_sorted_arrays(nums1, nums2);
    println!("{}", s);
}
