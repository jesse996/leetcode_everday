package 剑指offer;

/**
 * Created by jesse on 2020/11/14 下午1:15
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * db[i][j]=max{db[i-1][j],db[i][j-1]}+grid[i][j]
 */
public class T47 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] db = new int[row][column];
        db[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            db[i][0] = db[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < column; j++) {
            db[0][j] = db[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row;i++) {
            for (int j = 1; j < column; j++) {
                db[i][j] = Math.max(db[i - 1][j], db[i][j - 1]) + grid[i][j];
            }
        }
        return db[row - 1][column - 1];
    }
}
