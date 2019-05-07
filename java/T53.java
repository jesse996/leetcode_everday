// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

// 示例:

// 输入: [-2,1,-3,4,-1,2,1,-5,4],
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 进阶:

// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

// class T53 {
//   public int maxSubArray(int[] nums) {
//     int n = nums.length;
//     int sum = 0;
//     int ret = nums[0];
//     for (int i = 0; i < n; i++) {
//         sum=sum>0?sum+nums[i]:nums[i];
//         ret=ret<sum?sum:ret;
//     }
//     return ret;
//   }
//   public static void main(String[] args) {
    
//   }
// }
//分治法
class T53{
  public int maxSubArray(int[] nums) {
    return this.solve(nums, 0, nums.length-1);
  }
  public int solve(int[] nums,int left,int right){
    if(left>right) return 0;
    if (right-left<2) {
      return Math.max(nums[left], nums[right]);
    }
    int mid=(left+right)/2;
    int leftMax=solve(nums, left, mid-1);
    int rightMax=solve(nums, mid+1, right);
    return Math.max(nums[mid], Math.max(leftMax, rightMax));

  }
}