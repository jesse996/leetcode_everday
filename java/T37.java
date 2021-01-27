/**
 * @Author: jesse
 * @Date: 2021/1/27 7:17 下午
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T37 {
    public void solveSudoku(char[][] board) {
        backtrace(board, 0, 0);
    }

    public boolean backtrace(char[][] board, int r, int c) {
        if (r == 9) return true;
        if (c == 9) {
            return backtrace(board, r + 1, 0);
        }
        for (char k = '1'; k <= '9'; k++) {
            if (board[r][c] != '.') {
                return backtrace(board, r, c + 1);
            }
            if (!valid(board, r, c, k)) continue;
            board[r][c] = k;

            if (backtrace(board, r, c + 1)) {
                return true;
            }
            board[r][c] = '.';
        }
        return false;
    }

    public boolean valid(char[][] board, int r, int c, int ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch) return false;
            if (board[r][i] == ch) return false;
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) return false;
        }
        return true;
    }
}
