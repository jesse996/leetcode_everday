import java.util.Arrays;

/**
 * @Author: jesse
 * @Date: 2021/1/30 3:48 下午
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class T204 {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int count =0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }
        return count;
    }
}
