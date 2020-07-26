package 剑指offer;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class T19 {
    /**
     * 从后往前
     * f[i][j]表示s的前n个和p的前j个是否匹配
     * 1.p最后一个是字符或者`.`：f[i][j]=f[i-1][j-1]
     * 2.p最后一个是`*`:分看*和不看*，
     * 2.1 看*：f[i][j]=[i-1][j]
     * 2.2 不看*：f[i][j]=f[i][j-2]
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成非空模式和空模式
                if (j == 0) {
                    f[i][0] = i == 0;
                } else {
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //看*
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'))
                            f[i][j] = f[i - 1][j];
                        //不看*
                        if (j >= 2)
                            f[i][j] |= f[i][j - 2];
                    }
                }
            }
        }
        return f[n][m];
    }
}
