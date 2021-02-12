import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jesse on 2021/2/12 下午8:32
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class T119 {
    public List<Integer> getRow(int rowIndex) {
//        List<Integer> row = new ArrayList<Integer>();
//        row.add(1);
//        for (int i = 1; i <= rowIndex; ++i) {
//            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
//        }
//        return row;
        Integer[] res = new Integer[rowIndex + 1];
        res[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            res[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return Arrays.asList(res);
    }
}
