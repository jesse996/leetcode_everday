/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * 示例1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释:
 * <p>
 * 输入不存在公共前缀。
 * 说明：
 * <p>
 * 所有输入只包含小写字母 a-z
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                if (prefix.length() <= 0) return "";
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
