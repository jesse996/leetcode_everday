import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesse on 2021/2/8 下午2:34
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class T22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        help(n, n, res, "");
        return res;
    }

    public void help(int left, int right, List<String> list, String s) {
        if (left > right) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            list.add(s);
        }
        String s1 = s + "(";
        help(left - 1, right, list, s1);
        String s2 = s + ")";
        help(left, right - 1, list, s2);
    }
}
