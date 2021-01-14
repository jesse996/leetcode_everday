import java.util.Arrays;

/**
 * @Author: jesse
 * @Date: 2021/1/14 7:17 下午
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T647 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
//        //法1
//        int[] db = new int[n];
//        Arrays.fill(db, 1);
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                db[i] = db[i - 1] + 1;
//            }
//        }
//        int res = 0;
//        for (int num : db) {
//            res = Math.max(res, num);
//        }

        //法2
        int res = 1, db = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                db = db + 1;
                res = Math.max(res, db);
            } else {
                db = 1;
            }
        }
        return res;
    }
}
