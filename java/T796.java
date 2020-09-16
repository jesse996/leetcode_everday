/**
 * 给定两个字符串, A 和 B。A 的旋转操作就是将 A 最左边的字符移动到最右边。例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
 * 如果在若干次旋转操作之后，A 能变成B，那么返回True。
 */
public class T796 {
    //法1：kmp
    public boolean rotateString(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;
        String s = A + A;
        buildNext(B);
        return kmp(s, B) != -1;
    }

    static int[] next;

    static int kmp(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == p.length() ? i - j : -1;
    }

    static void buildNext(String p) {
        next = new int[p.length()];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }


    //法2：
    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
