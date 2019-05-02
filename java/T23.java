// 合并K个排序链表
// 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

// 示例:

// 输入:
// [
// 1->4->5,
// 1->3->4,
// 2->6
// ]
// 输出: 1->1->2->3->4->4->5->6

//  * Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

//分治法，分成多个合并2个
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length==0){
      return null;
    }
    if(lists.length==1){
      return lists[0];
    }
    if(lists.length==2){
      return mergeTwoLists(lists[0], lists[1]);
    }
    int mid=lists.length/2;
    ListNode[] l1=new ListNode[mid];
    ListNode[] l2=new ListNode[lists.length-mid];
    for(int i=0;i<mid;i++){
      l1[i]=lists[i];
    }
    for(int i=0;i<lists.length-mid;i++){
      l2[i]=lists[i+mid];
    }
    return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
  }
  public ListNode mergeTwoLists(ListNode l1,ListNode l2){
    if (l1==null) {
      return l2;
    }
    if (l2==null) {
      return l1;
    }
    if(l1.val<l2.val){
      l1.next=mergeTwoLists(l1.next, l2);
      return l1;
    }else{
      l2.next=mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}

