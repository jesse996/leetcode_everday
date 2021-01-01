/**
 * @Author: jesse
 * @Date: 2021/1/1 5:47 下午
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int maxK = k;
        if (maxK>n/2){
            return maxProfitInf(prices);
        }
        int[][][] dp = new int[n][maxK + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= maxK; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }

    public int maxProfitInf(int[] prices) {
        int n = prices.length;
        int i0 = 0, i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = i0;
            i0 = Math.max(i0, i1 + prices[i]);
            i1 = Math.max(i1, tmp - prices[i]);
        }
        return i0;
    }
}
