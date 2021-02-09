import java.util.*;

/**
 * Created by jesse on 2021/2/9 上午10:24
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * <p>
 * 返回 A 中好子数组的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return help(A, K) - help(A, K - 1);
    }

    //A的某个子数组中不同整数的个数最多为 K的子数组个数
    public int help(int[] A, int K) {
        int len = A.length;
        int l = 0, r = 0;
        int[] freq = new int[len + 1];
        int count = 0;
        int res = 0;
        while (r < len) {
            if (freq[A[r]] == 0) {
                count++;
            }
            freq[A[r]]++;
            r++;
            while (count > K) {
                freq[A[l]]--;
                if (freq[A[l]] == 0) {
                    count--;
                }
                l++;
            }
            res += r - l;
        }
        return res;
    }
}
