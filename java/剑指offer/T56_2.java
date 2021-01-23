package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jesse
 * @Date: 2021/1/23 2:31 下午
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class T56_2 {
    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.get(nums[i]) != i) {
//                map.put(nums[i], -1);
//            }else {
//                return nums[i];
//            }
//        }
//        return -1;
        int a = 0, b = 0;
        for (int i : nums) {
            a = (a ^ i) & ~b;
            b = (b ^ i) & ~a;
        }
        return a;
    }
}
