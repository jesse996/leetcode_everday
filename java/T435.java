import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @Author: jesse
 * @Date: 2021/1/17 2:53 下午
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int res = 1;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        int end = intervals[0][1];
        for (int[] num : intervals) {
            int start = num[0];
            if (start >= end) {
                res++;
                end = num[1];
            }
        }
        return intervals.length - res;
    }
}
