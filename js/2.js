/**
  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
  let res = new ListNode(0),
    carry = 0,
    p = res
  while (l1 || l2) {
    let x = l1 ? l1.val : 0,
      y = l2 ? l2.val : 0,
      sum = x + y + carry
    p.val = ~~(sum % 10)
    carry = ~~(sum / 10)
    l1 ? (l1 = l1.next) : ''
    l2 ? (l2 = l2.next) : ''
    if (l1 || l2 || carry) {
      p.next = new ListNode(carry)
    }
    p = p.next
  }
  return res
}
