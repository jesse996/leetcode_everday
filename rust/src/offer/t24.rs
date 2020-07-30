use std::option::Option::Some;

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

pub fn reverse_list(mut head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut h = ListNode::new(0);
    while let Some(mut head_unwrap)=head{
        let tmp = head_unwrap.next.take();
        head_unwrap.next = h.next;
        h.next = Some(head_unwrap);
        head = tmp;
    }
    h.next
}