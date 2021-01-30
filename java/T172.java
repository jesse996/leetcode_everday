/**
 * @Author: jesse
 * @Date: 2021/1/30 2:40 下午
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class T172 {
    public int trailingZeroes(int n) {
        int res=0;
        for (int i = n; i / 5 > 0; i /= 5) {
            res += i / 5;
        }
        return res;
    }
}
