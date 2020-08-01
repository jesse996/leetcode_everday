use std::borrow::BorrowMut;

#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode {
            next: None,
            val,
        }
    }
}

pub fn merge_two_lists(mut l1: Option<Box<ListNode>>, mut l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut head = ListNode::new(0);
    let mut p = &mut head;
    while l1.is_some() && l2.is_some() {
        if l1.as_ref().unwrap().val < l2.as_ref().unwrap().val {
            let next = l1.as_mut().unwrap().next.take();
            p.next = l1;
            l1 = next;
        } else {
            let next = l2.as_mut().unwrap().next.take();
            p.next = l2;
            l2 = next;
        }
        p = p.next.as_mut().unwrap();
    }
    p.next = if l1.is_some() { l1 } else { l2 };
    head.next
}