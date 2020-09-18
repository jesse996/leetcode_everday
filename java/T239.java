import java.util.*;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 */
public class T239 {
    //一：暴力
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        if (len * k == 0) return new int[0];
//        int[] win = new int[len - k + 1];
//        //遍历所有的滑动窗口
//        for (int i = 0; i < len - k + 1; i++) {
//            int max = Integer.MIN_VALUE;
//            //找到每一个滑动窗口的最大值
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            win[i] = max;
//        }
//        return win;
//    }
    //二：双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (i > 0 && !deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            if (i >= k-1) {
                res[i - k + 1] = deque.peekFirst();
            }

        }
        return res;
    }
}
