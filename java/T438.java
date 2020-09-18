import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 */
public class T438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.isEmpty() || p.isEmpty() || s.length() < p.length()) return new ArrayList<>();

        int[] sArr = new int[26];
        int[] pArr = new int[26];
        int pLen = p.length();
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < pLen; i++) {
            sArr[s.charAt(i) - 'a'] += 1;
            pArr[p.charAt(i) - 'a'] += 1;
        }
        int i = 0, j = pLen;
        while (j < sLen ) {
            if (isSame(sArr, pArr)) res.add(i);
            sArr[s.charAt(i) - 'a'] -= 1;
            i += 1;
            sArr[s.charAt(j) - 'a'] += 1;
            j += 1;
        }
        if (isSame(sArr, pArr)) res.add(i);
        return res;

    }

    public boolean isSame(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
