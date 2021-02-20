import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jesse
 * @Date: 2021/2/20 1:28 下午
 */
public class T697 {
    public int findShortestSubArray(int[] nums) {
        //划动窗口法
//        Map<Integer, Integer> need = new HashMap<>(), window = new HashMap<>();
//        for (int n : nums) {
//            need.put(n, need.getOrDefault(n, 0) + 1);
//        }
//        //数组的度
//        int du = need.values().stream().max(Comparator.comparingInt(x -> x)).get();
//        int res = Integer.MAX_VALUE;
//        int left = 0, right = 0;
//        int len = nums.length;
//        while (right < len) {
//            int current = nums[right++];
//            window.put(current, window.getOrDefault(current, 0) + 1);
//            int winDu = window.values().stream().max(Comparator.comparingInt(x -> x)).get();
//            while (winDu == du) {
//                res = Math.min(res, right - left);
//                int pre = nums[left++];
//                window.put(pre, window.get(pre) - 1);
//                if (window.get(pre) == 0) window.remove(pre);
//                if (window.isEmpty()) break;
//                winDu = window.values().stream().max(Comparator.comparingInt(x -> x)).get();
//            }
//        }
//        return res;
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[2] = i;
                map.get(nums[i])[0]++;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (int[] arr : map.values()) {
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }
        return minLen;
    }
}
