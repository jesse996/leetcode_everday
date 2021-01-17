/**
 * @Author: jesse
 * @Date: 2021/1/17 3:43 下午
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
public class T55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int far = 0;
        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (far <= i) return false;
        }
        return far >= n - 1;
    }
}
