package 剑指offer;

/**
 * Created by jesse on 2020/12/27 下午10:31
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T53_2 {
    /**
     * 对于有序的数组, 都应该想到用二分法搜索
     * 然后找规律
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] < mid) {
                right = mid - 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        // 如果从0 ~ n - 1都不缺值, 则缺少的是n
        return  left == nums.length - 2 && nums[left] == left ? left + 1 : left;
    }
}
