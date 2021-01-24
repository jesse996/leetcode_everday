package 剑指offer;

import java.util.Arrays;

/**
 * @Author: jesse
 * @Date: 2021/1/23 11:59 下午
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int zeroCount = 0, diff = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            } else {
                diff += nums[i + 1] - nums[i] - 1;
            }
        }
        return zeroCount >= diff;
    }
}
