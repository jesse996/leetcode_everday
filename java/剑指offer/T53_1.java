package 剑指offer;

/**
 * Created by jesse on 2020/12/8 下午8:57
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T53_1 {
    public int search(int[] nums, int target) {
//        暴力法
//        int res = 0;
//        for (int num : nums) {
//            if (num == target) {
//                res += 1;
//            }
//        }
//        return res;

        //二分法
        int res = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        while (left < nums.length && nums[left] == target) {
            res += 1;
            left += 1;
        }
        return res;
    }
}
