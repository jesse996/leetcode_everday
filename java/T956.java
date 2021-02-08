import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jesse on 2021/2/8 下午3:37
 * 你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
 * <p>
 * 你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
 * <p>
 * 返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tallest-billboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T956 {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> copy = new HashMap<>();
        map.put(0, 0);
        for (int i : rods) {
            copy.clear();
            copy.putAll(map);
            for (Map.Entry<Integer, Integer> entry : copy.entrySet()) {
                map.put(entry.getKey() + i, Math.max(map.getOrDefault(entry.getKey() + i, 0), entry.getValue() + i));
                map.put(entry.getKey() - i, Math.max(map.getOrDefault(entry.getKey() - i, 0), entry.getValue()));
            }
        }
        return map.get(0);
    }
}
