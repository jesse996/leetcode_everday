/**
 * @Author: jesse
 * @Date: 2021/1/27 2:55 下午
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int r, int c) {
        char ch = board[r][c];
        if (board[r][c] == '.') {
            return true;
        }
        for (int i = 0; i < 9; i++) {
            if (i != r && board[i][c] == ch) {
                return false;
            }
            if (i != c && board[r][i] == ch) {
                return false;
            }
            if (((r / 3) * 3 + i / 3) != r && ((c / 3) * 3 + i % 3) != c && board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }

}
