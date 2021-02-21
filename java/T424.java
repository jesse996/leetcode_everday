import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: jesse
 * @Date: 2021/2/21 2:53 下午
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 104。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T424 {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0, right = 0;
        int[] freq = new int[26];
        int maxCount = 0;
        int res = 0;
        while (right < n) {
            freq[arr[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[arr[right] - 'A']);
            right++;
            if (right - left > maxCount + k) {
                freq[arr[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
