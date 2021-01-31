import java.util.Arrays;
import java.util.Random;

/**
 * @Author: jesse
 * @Date: 2021/1/31 1:57 下午
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T398 {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */
    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int c = 0, index = 0;
            Random r = new Random();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    c++;
                    if (r.nextInt(c) == 0) {
                        index = i;
                    }
                }
            }
            return index;
        }
    }
}
