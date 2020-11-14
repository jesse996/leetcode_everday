package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jesse on 2020/11/14 下午1:27
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * db[i]为包含第i个字符的最长不含重复字符的子字符串的数量
 * db[i]=db[i-1]+1 if char[i] not in set[i-db[i-1]]
 * else db[i]=1
 */
public class T48 {
    public int lengthOfLongestSubstring(String s) {
//        int res = 0, tmp = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int j = 0; j < s.length(); j++) {
//            int i = map.getOrDefault(s.charAt(j), -1);
//            map.put(s.charAt(j), j);
//            tmp=tmp<j-i?tmp+1:j-i;
//            res = Math.max(res, tmp);
//        }
//        return res;
        int i = -1, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        T48 t48 = new T48();
        t48.lengthOfLongestSubstring(s);
    }
}
