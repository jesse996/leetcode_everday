import java.util.Arrays;

/**
 * @Author: jesse
 * @Date: 2021/1/14 7:44 下午
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x1, x2) -> x1[0] == x2[0] ? x2[1] - x1[1] : x1[0] - x2[0]);
        int piles = 0, n = envelopes.length;
        int[] top = new int[n];
        for (int[] envelope : envelopes) {
            int park = envelope[1];
            int left = 0, right = piles - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (top[mid] < park) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left == piles) piles++;
            top[left] = park;
        }
        return piles;
    }
}
