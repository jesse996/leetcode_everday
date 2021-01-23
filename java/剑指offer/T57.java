package 剑指offer;

/**
 * @Author: jesse
 * @Date: 2021/1/23 3:00 下午
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class T57 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return null;
    }
}
