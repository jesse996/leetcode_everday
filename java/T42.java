/**
 * @Author: jesse
 * @Date: 2021/2/2 2:22 下午
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 */
public class T42 {
    public int trap(int[] height) {
        int n = height.length;
        int lm = 0, rm = 0;
        int left = 0, right = n - 1;
        int res = 0;
        while (left <= right) {
            lm = Math.max(lm, height[left]);
            rm = Math.max(rm, height[right]);
            if (lm > rm) {
                res += rm - height[right];
                right--;
            } else {
                res += lm - height[left];
                left++;
            }
        }
        return res;

    }
}
