/**
 * @Author: jesse
 * @Date: 2021/2/24 11:56 上午
 */
public class T832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int tmp = A[i][l] ^ 1;
                A[i][l] = A[i][r] ^ 1;
                A[i][r] = tmp;
                l++;
                r--;
            }
            if (l == r) A[i][l] ^= 1;
        }
        return A;
    }
}
