import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jesse
 * @Date: 2021/1/31 7:10 下午
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class T560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res=0,sumI=0;
        for (int i = 0; i < n; i++) {
            sumI += nums[i];
            int sumJ = sumI - k;
            if (map.containsKey(sumJ)) {
                res += map.get(sumJ);
            }
            map.put(sumI, map.getOrDefault(sumI, 0) + 1);
        }
        return res;
    }
}
