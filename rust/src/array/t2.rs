// 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
//
// 以下是井字游戏的规则：
//
// 玩家轮流将字符放入空位（" "）中。
// 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
// "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
// 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
// 当所有位置非空时，也算为游戏结束。
// 如果游戏结束，玩家不允许再放置字符。
// 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
//
// 示例 1：
//
// 输入： board = ["O X"," XO","X O"]
// 输出： "X"
// 示例 2：
//
// 输入： board = ["OOX","XXO","OXO"]
// 输出： "Draw"
// 解释： 没有玩家获胜且不存在空位
// 示例 3：
//
// 输入： board = ["OOX","XXO","OX "]
// 输出： "Pending"
// 解释： 没有玩家获胜且仍存在空位
// 提示：
//
// 1 <= board.length == board[i].length <= 100
// 输入一定遵循井字棋规则
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/tic-tac-toe-lcci
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

pub fn tictactoe(board: Vec<String>) -> String {
    let n = board.len();
    let mut row = vec![0; n];
    let mut col = vec![0; n];
    let mut is_full = true;
    let mut dia1 = 0;
    let mut dia2 = 0;

    for i in 0..n {
        for j in 0..n {
            let mut offset = 0i32;
            if board[i].chars().nth(j).unwrap() == 'X' { offset = 1 } else if board[i].chars().nth(j).unwrap() == 'O'{ offset = -1 } else { is_full = false; }
            if i == j {
                dia1 += offset;
            }
            if i + j == n - 1 {
                dia2 += offset;
            }
            row[i] += offset;
            col[j] += offset;
        }
    }
    if dia1 as usize == n || dia2 as usize == n {
        return "X".to_string();
    } else if dia1 == -(n as i32) || dia2 == -(n as i32) {
        return "O".to_string();
    }

    for i in 0..n {
        if row[i] == n as i32 || col[i] == n as i32 {
            return "X".to_string();
        } else if row[i] == -(n as i32) || col[i] == -(n as i32) {
            return "O".to_string();
        }
    };
     if is_full {
        "Draw".to_string()
    } else {
        "Pending".to_string()
    }
}