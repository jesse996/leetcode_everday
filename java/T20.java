import java.util.*;

/**
 * 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()" 输出: true 示例 2:
 * 
 * 输入: "()[]{}" 输出: true 示例 3:
 * 
 * 输入: "(]" 输出: false 示例 4:
 * 
 * 输入: "([)]" 输出: false 示例 5:
 * 
 * 输入: "{[]}" 输出: trueF
 */
// 1.用栈
// class Solution {
// public boolean isValid(String s) {
// int len = s.length();
// char[] stack = new char[len];
// int k = -1;
// char[] list = s.toCharArray();
// for (int i = 0; i < list.length; i++) {
// if (list[i] == '(' || list[i] == '[' || list[i] == '{') {
// stack[++k] = list[i];
// } else {
// if (k < 0) {
// return false;
// }
// if (stack[k] == '[' && list[i] != ']') {
// return false;
// } else if (stack[k] == '(' && list[i] != ')') {
// return false;
// } else if (stack[k] == '{' && list[i] != '}') {
// return false;
// }
// k--;
// }
// }
// if (k >= 0) {
// return false;
// }
// return true;
// }
// }

// 2 。用ackII之差

class T20 {
  public boolean isValid(String s) {
    int len = s.length();
    char[] list = s.toCharArray();
    char[] stack = new char[len/2];
    int k = -1;
    for (int i = 0; i < len; i++) {
      if (list[i] == '[' || list[i] == '(' || list[i] == '{') {
        stack[++k]=list[i];
      }else if(list[i]==stack[k]+1||list[i]==stack[k]+2){
        k--;
      }else{
        return false;
      }
    }
    if(k>=0){
      return false;
    }
    return true;
  }
}