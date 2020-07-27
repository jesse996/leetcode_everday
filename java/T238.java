// 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

// 示例:

// 输入: [1,2,3,4]
// 输出: [24,12,8,6]
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

// 进阶：
// 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

class T238 {
  public int[] productExceptSelf(int[] nums) {
    int left = 1, right = 1;
    int n = nums.length;
    int[] output = new int[n];
    for (int i = 0; i < n; i++) {
      output[i] = left;
      left *= nums[i];
    }
    for (int j = n - 1; j >= 0; j--) {
      output[j] *= right;
      right *= nums[j];
    }
    return output;
  }
}