import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @Author: jesse
 * @Date: 2021/2/21 1:41 下午
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T1438 {
//    public int longestSubarray(int[] nums, int limit) {
//        int n = nums.length;
//        int left = 0, right = 0;
//        int res = 0;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        while (right < n) {
//            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
//            right++;
//            while (map.lastKey() - map.firstKey() > limit) {
//                map.put(nums[left], map.get(nums[left]) - 1);
//                if (map.get(nums[left]) == 0) {
//                    map.remove(nums[left]);
//                }
//                left++;
//            }
//            res = Math.max(res, right - left);
//        }
//        return res;
//    }

    //单调队列
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> minQueue = new LinkedList<>(), maxQueue = new LinkedList<>();
        int left = 0, right = 0;
        int n = nums.length;
        int res=0;
        while (right < n) {
            while (!minQueue.isEmpty() && minQueue.getLast() > nums[right]) {
                minQueue.pollLast();
            }
            while (!maxQueue.isEmpty() && maxQueue.getLast() < nums[right]) {
                maxQueue.pollLast();
            }
            minQueue.addLast(nums[right]);
            maxQueue.addLast(nums[right]);
            while (maxQueue.getFirst() - minQueue.getFirst() > limit) {
                if (minQueue.getFirst() == nums[left]) {
                    minQueue.pollFirst();
                }
                if (maxQueue.getFirst() == nums[left]) {
                    maxQueue.pollFirst();
                }
                left++;
            }
            right++;
            res = Math.max(res,right - left);
        }
        return res;
    }
}
