/**
 * @Author: jesse
 * @Date: 2021/2/23 11:36 下午
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //不用技巧的满意客户人数
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int add = grumpy[0] == 0 ? 0 : customers[0];
        int res = sum + add;
        //i表示右边，i-X表示左边
        for (int i = 1; i < customers.length ; i++) {
            if (i  < X) {
                if (grumpy[i] == 1)
                    add += customers[i];
            } else {
                if (grumpy[i ] == 1) add += customers[i];
                if (grumpy[i - X] == 1) add -= customers[i - X];
            }
            res = Math.max(res, sum + add);

        }
        return res;
    }
}
