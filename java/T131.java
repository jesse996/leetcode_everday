import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jesse on 2021/3/7 下午3:24
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 */
public class T131 {
    int n;
    boolean[][] f;

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        n = s.length();
        f = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            Arrays.fill(f[i], true);
        }
        //这里必须逆序
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = f[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        traverse(s, 0, res, new ArrayList<>());
        return res;
    }

    public void traverse(String s, int i, List<List<String>> res, List<String> tmp) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        int n = s.length();
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                tmp.add(s.substring(i, j + 1));
                traverse(s, j + 1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
