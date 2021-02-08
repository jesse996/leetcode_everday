/**
 * Created by jesse on 2021/2/8 下午1:13
 * <p>
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T978 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return n;
        }
        //ture表示arr[i-1]<arr[i]
        boolean pre = false;
        int l = 0, r = 1;
        int res = 0;
        while (r < n) {
            boolean current = arr[r] - arr[r - 1] > 0;
            if (current == pre) l = r - 1;
            if (arr[r] == arr[r - 1]) l = r;
            r++;
            res = Math.max(res, r - l);
            pre = current;
        }
        return res;
    }
}
