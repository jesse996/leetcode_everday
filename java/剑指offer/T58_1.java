package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author: jesse
 * @Date: 2021/1/23 4:54 下午
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T58_1 {
    public String reverseWords(String s) {
        String[] array = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].equals(" ") || array[i].equals("")) continue;
            sb.append(array[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
