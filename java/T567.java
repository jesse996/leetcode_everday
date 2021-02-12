import java.util.HashMap;
import java.util.Map;

/**
 * Created by jesse on 2021/2/10 上午10:27
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class T567 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        int valid = 0;
        for (char s : s1.toCharArray()) {
            need.put(s, need.getOrDefault(s, 0) + 1);
        }

        int l = 0, r = 0;
        while (r < n) {
            char c = s2.charAt(r);
            r++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (r - l >= m) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(l);
                l++;
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return false;
    }
}
