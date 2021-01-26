import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jesse
 * @Date: 2021/1/26 8:01 下午
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] cp = new int[100];
        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            res += cp[domino[0] * 10 + domino[1]]++;
        }
        return res;
    }
}
