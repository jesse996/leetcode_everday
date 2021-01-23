package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jesse
 * @Date: 2021/1/20 8:01 下午
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class T56_1 {
    public int[] singleNumbers(int[] nums) {
        int sum=0;
        int[] res = new int[2];
        for (int n : nums) {
            sum ^= n;
        }
        //flag是只保留了最低位的1，比如10010变成00010;
        int flag = (-sum) & sum;
        for (int n : nums) {
            if ((flag & n) == 0) {
                res[0] ^= n;
            }else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
