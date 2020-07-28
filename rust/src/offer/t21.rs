pub fn exchange(mut nums: Vec<i32>) -> Vec<i32> {
    if nums.len() == 0 { return nums; }
    let mut i = 0;
    let mut j = nums.len() - 1;
    while i < j {
        while i < j && nums[i] & 1 == 1 {
            i += 1;
        }
        while i < j && nums[j] & 1 != 1 {
            j -= 1;
        }
        nums.swap(i, j);
    }
    nums
}