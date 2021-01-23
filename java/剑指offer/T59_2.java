package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: jesse
 * @Date: 2021/1/23 10:45 下午
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T59_2 {
    class MaxQueue {
        private Deque<Integer> deque;
        private Deque<Integer> help;

        public MaxQueue() {
            deque = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public int max_value() {
            return help.isEmpty() ? -1 : help.getFirst();
        }

        public void push_back(int value) {
            deque.offerLast(value);
            while (!help.isEmpty() && help.getLast() < value) {
                help.pollLast();
            }
            help.offerLast(value);
        }

        public int pop_front() {
            if (deque.isEmpty()) {
                return -1;
            }
            int v = deque.pollFirst();
            if (v == help.getFirst()) {
                help.pollFirst();
            }
            return v;
        }
    }
}
