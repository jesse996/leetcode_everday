package 剑指offer;

/**
 * Created by jesse on 2020/11/26 下午7:52
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T50 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[26];
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            arr[chars[i] - 'a'] = i;
        }
        for (int i = 0; i < len; i++) {
            if (i == arr[chars[i] - 'a']) {
                return chars[i];
            }
            arr[chars[i] - 'a'] = -1;
        }
        return ' ';
    }
}
