/**
 * @Author: jesse
 * @Date: 2021/2/7 11:43 上午
 * <p>
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T665 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                cnt++;
                if (cnt > 1) return false;
                if (i > 0 && nums[i + 1] < nums[i - 1]) nums[i + 1] = nums[i];
            }
        }
        return true;
    }
}
