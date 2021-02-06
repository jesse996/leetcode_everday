import java.util.Arrays;

/**
 * @Author: jesse
 * @Date: 2021/2/6 11:18 上午
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T1423 {
    //就是求连续的n-k的最小值
    public int maxScore(int[] cardPoints, int k) {
        int windowSize = cardPoints.length - k;
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }
        int min = sum;
        for (int i = windowSize; i < cardPoints.length; i++) {
            sum += cardPoints[i] - cardPoints[i - windowSize];
            min = Math.min(min, sum);
        }
        return Arrays.stream(cardPoints).sum() - min;
    }

}
