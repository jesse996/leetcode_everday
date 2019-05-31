// 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

// 你可以假设数组是非空的，并且给定的数组总是存在众数。

// 示例 1:

// 输入: [3,2,3]
// 输出: 3
// 示例 2:

// 输入: [2,2,1,1,1,2,2]
// 输出: 2

//摩尔投票法
class Solution {
  public int majorityElement(int[] nums) {
    int maj = nums[0], count = 1;
    for (int i = 1; i < nums.length - 1; i++) {
      if (maj == nums[i])
        count++;
      else {
        count--;
        if (count == 0) {
          maj = nums[i + 1];
        }
      }
    }
    return maj;
  }
}