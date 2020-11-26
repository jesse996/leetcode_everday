package 剑指offer;

/**
 * Created by jesse on 2020/11/26 下午8:07
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right]计算逆序数并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPair = reversePairs(nums, left, mid, temp);
        int rightPair = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPair + rightPair;
        }

        int crossPair = mergeAndCount(nums, left, mid, right, temp);
        return leftPair + rightPair + crossPair;
    }

    /**
     * nums[left..mid]有序， nums[mid+1..right]有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j += 1;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i += 1;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i += 1;
            } else {
                nums[k] = temp[j];
                j += 1;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
