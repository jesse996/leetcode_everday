use std::option::Option::Some;

// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}
pub fn get_kth_from_end(head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
    let mut p=&head;
    let mut q=&head;
    let mut n=0;
    while let Some (node)=p{
        p= &node.next;
        n+=1;
        if n>k {
            q= &q.as_ref().unwrap().next;
        }
    }
    q.to_owned()
}