import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: jesse
 * @Date: 2021/1/26 3:52 下午
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Stack<Integer> s = new Stack<>();
//        int[] res = new int[nums2.length];
//        for (int i = nums2.length - 1; i >= 0; i--) {
//            while (!s.isEmpty() && s.peek() <= nums2[i]) {
//                s.pop();
//            }
//            res[i] = s.isEmpty() ? -1 : s.peek();
//            s.push(nums2[i]);
//        }
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; i < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    nums1[i] = res[j];
//                    break;
//                }
//            }
//        }
//        return nums1;
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums2) {
            while (!s.isEmpty() && s.peek() <= n) {
                map.put(s.pop(), n);
            }
            s.push(n);
        }
        while (!s.isEmpty()) {
            map.put(s.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;

    }
}
