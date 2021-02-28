/**
 * Created by jesse on 2021/2/28 下午8:43
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T896 {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        boolean a=true, b=true;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] < A[i + 1]) {
                a = false;
            }
            if (A[i] > A[i + 1]) {
                b = false;
            }
        }
        return a || b;

    }
}
