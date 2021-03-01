/**
 * Created by jesse on 2021/3/1 上午9:17
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T303 {
    class NumArray {
        //num[i]=preSum[i+1]-preSum[i];
        private int[] preSum;
        public NumArray(int[] nums) {
            int n = nums.length;
            preSum = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j + 1] - preSum[i];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
}
