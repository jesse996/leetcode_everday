import java.util.HashMap;
import java.util.Map;

/**
 * Created by jesse on 2021/2/14 上午10:39
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * <p>
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * <p>
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T765 {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int total = n / 2;
        int[] f = new int[total];
        for (int i = 0; i < total; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i += 2) {
            add(f, row[i] / 2, row[i + 1] / 2);
        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < total; i++) {
//            int root = find(f, i);
//            map.put(root, map.getOrDefault(root, 0) + 1);
//        }
//        int res = 0;
//        for (int value : map.values()) {
//            res += value - 1;
//        }
//        return res;
        int cnt = 0;
        for (int i = 0; i < total; i++) {
            if (find(f, i) == i) {
                cnt++;
            }
        }
        return total - cnt;

    }

    public int find(int[] f, int x) {
        while (f[x] != x) {
            f[x] = f[f[x]];
            x = f[x];
        }
        return x;
    }

    public void add(int[] f, int a, int b) {
        int rootA = find(f, a);
        int rootB = find(f, b);
        if (rootA == rootB) return;
        f[rootA] = rootB;
    }
}
