package 剑指offer;

import java.util.*;

/**
 * @Author: jesse
 * @Date: 2021/1/23 9:48 下午
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class T59_1 {
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) {
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.offerLast(n);
        }

        public void pop(int n) {
            if (q.getFirst() == n) {
                q.pollFirst();
            }
        }

        public int max() {
            return q.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                res.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
}
