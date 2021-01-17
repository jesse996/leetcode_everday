/**
 * @Author: jesse
 * @Date: 2021/1/17 3:57 下午
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int far = 0, end = 0;
        int jump=0;
        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                end=far;
                jump++;
            }
        }
        return jump;
    }
}
