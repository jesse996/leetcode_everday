/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb" 最长回文子串
 */

// 1.动态规划法
class T5 {
  public String longestPalindrome(String s) {
    if (s.length() == 0) {
      return "";
    }
    int[][] map = new int[s.length()][s.length()];
    int maxLen = 1, start = 0;
    // map[i][j]==1表示从 i 到 j 是一个回文
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        if (j - i < 2) {
          map[i][j]=s.charAt(i)==s.charAt(j)?1:0;
        } else {
          map[i][j] = map[i + 1][j - 1] == 1&&s.charAt(i)==s.charAt(j) ? 1 : 0;
        }
        if (map[i][j]==1&&(j - i + 1) > maxLen) {
          start = i;
          maxLen = j - i + 1;
        }
      }
    }
    return s.substring(start, maxLen + start);
  }

  public static void main(String[] args) {
    System.out.println(new T5().longestPalindrome("abcba"));
  }
}