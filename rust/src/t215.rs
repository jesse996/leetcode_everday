struct Solution;


impl Solution {
    pub fn find_kth_largest(mut nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        Self::partition(&mut nums, 0, n - 1, n - k as usize)
    }
    pub fn partition(nums: &mut Vec<i32>, l: usize, r: usize, k: usize) -> i32 {
        if l >= r { return nums[l]; };
        let pivot = nums[l];
        let mut i = l;
        let mut j = r;
        while i < j {
            while i < j && nums[j] >= pivot {
                j -= 1;
            }
            nums[i] = nums[j];
            while i < j && nums[i] <= pivot {
                i += 1;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        if i > k {
            Self::partition(nums, l, i - 1, k)
        } else if i < k {
            Self::partition(nums, i + 1, r, k)
        } else {
            nums[i]
        }
    }
}