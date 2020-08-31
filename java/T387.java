/**
 * 第387题：字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1 。
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 */
public class T387 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        //先记录每个字符最后一次出现的引索
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        //如果第一次引索和记录的不一样说明有重复
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)-'a'] != i) {
                arr[s.charAt(i)-'a'] = -1;
            } else {
                return i;
            }
        }
        return -1;
    }
}
