import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jesse
 * @Date: 2021/2/27 12:48 下午
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 */
public class T395 {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int left, int right, int k) {
        int[] cnt = new int[26];
        for (int i = left; i <= right; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) return right - left + 1;

        int res = 0;
        int i = left;
        while (i <= right) {
            while (i <= right && s.charAt(i) == split) i++;
            if (i > right) break;

            int start = i;
            while (i <= right && s.charAt(i) != split) i++;
            res = Math.max(res, dfs(s, start, i - 1, k));
        }
        return res;
    }
}
