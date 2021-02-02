import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @Author: jesse
 * @Date: 2021/2/2 7:40 下午
 * 我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
 * <p>
 * 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T391 {


    public boolean isRectangleCover(int[][] rectangles) {
        int actualArea = 0;
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE, X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;
        Set<String> points = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];
            actualArea += (x2 - x1) * (y2 - y1);
            X1 = Math.min(X1, x1);
            X2 = Math.max(X2, x2);
            Y1 = Math.min(Y1, y1);
            Y2 = Math.max(Y2, y2);

            int[][] ps = new int[][]{{x1, y1}, {x1, y2}, {x2, y1}, {x2, y2}};
            for (int[] p : ps) {
                String l = p[0] + " " + p[1];
                if (points.contains(l)) points.remove(l);
                else points.add(l);
            }
        }

        int expectArea = (X2 - X1) * (Y2 - Y1);
        if (actualArea != expectArea) return false;
        if (points.size() != 4) return false;
        int[][] ps = new int[][]{{X1, Y1}, {X1, Y2}, {X2, Y1}, {X2, Y2}};
        for (int[] p : ps) {
            String l = p[0] + " " + p[1];
            if (!points.contains(l)) return false;
        }
        return true;
    }
}
