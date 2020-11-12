package 剑指offer;

/**
 * Created by jesse on 2020/11/12 下午6:42
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 1位数，10个：0-9
 * 2位数，90个，9×10，10-99
 * 3位数，900个， 100-999
 * 4,9000个，1000-9999
 */
public class T44 {
    public int findNthDigit(int n) {
        long start = 1, count = 9;
        int  digit = 1;
        while (n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = start * digit * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
