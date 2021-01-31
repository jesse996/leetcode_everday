/**
 * @Author: jesse
 * @Date: 2021/1/31 9:59 上午
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 */
public class T372 {
    int base = 1337;

    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    public int superPow(int a, int[] b, int last) {
        if (last < 0) return 1;
        int l = b[last];
        int sub = myPow(a, l);
        int rest = myPow(superPow(a, b, last - 1), 10);
        return (sub * rest) % base;
    }

    public int myPow(int a, int k) {
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }
}
