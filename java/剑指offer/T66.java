package 剑指offer;

import java.util.Arrays;

/**
 * @Author: jesse
 * @Date: 2021/1/23 11:00 下午
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0, p = 1; i < n;p*=a[i], i++) {
            res[i] = p;
        }
        for (int i = n - 1, p = 1; i >= 0; p *= a[i], i--) {
            res[i] *= p;
        }
        return res;
    }
}
