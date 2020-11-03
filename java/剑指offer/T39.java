package 剑指offer;

/**
 * Created by jesse on 2020/11/3 下午8:48
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T39 {
    public int majorityElement(int[] nums) {
        int res = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                res = num;
            }
            votes += num == res ? 1 : -1;
        }
        return res;
    }
}
