/**
 * @Author: jesse
 * @Date: 2021/1/30 2:55 下午
 * f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1）
 * <p>
 * 例如， f(3) = 0 ，因为3! = 6的末尾没有0；而 f(11) = 2 ，因为11!= 39916800末端有2个0。给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/preimage-size-of-factorial-zeroes-function
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T793 {
    public int preimageSizeFZF(int K) {
        return (int) (rightBound(K) - leftBound(K)) + 1;
    }

    public long leftBound(int k) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (help(mid) >= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public long rightBound(int k) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (help(mid) <= k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    public long help(long n) {
        long res = 0;
        for (long i = n; i / 5 > 0; i /= 5) {
            res += i / 5;
        }
        return res;
    }
}
