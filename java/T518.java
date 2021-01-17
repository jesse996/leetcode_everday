/**
 * @Author: jesse
 * @Date: 2021/1/17 1:55 下午
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class T518 {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i - 1]];
            }
        }
        return dp[n];
    }
}
