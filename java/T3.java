import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3. Example 2:
 * <p>
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1. Example 3:
 * <p>
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * <p>
 * 就是找不重复的最长子串的长度
 */

class T3 {
    //    public int lengthOfLongestSubstring(String s) {
//        int ans = 0, n = s.length();
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0, j = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)) + 1, i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j);
//        }
//        return ans;
//    }
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int res = 0, n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, chars[s.charAt(j)]);
            res = Math.max(res, j - i + 1);
            chars[s.charAt(j)] = j + 1;
        }
        return res;
    }
}

// 通过一个滑动窗口 [i,j),初始j=i=0
// 用一个map，key为 s[j],value为j，不断j++,直到map中有重复的s[j']和s[j]（j'<j）,此时i直接变为j'+1,
//   abba
//1: i=0,b=0;
//2: i=0,b=1
//3: i=0,b=2,此时有重复，让i=1+1=2
//4: i=2,b=2
//5: i=2,b=3