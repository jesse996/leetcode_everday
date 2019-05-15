type
    ListNode = ref object
        val: int
        next: ListNode

proc addTwoNumbers(l1, l2: ListNode):  ListNode =
    var head: ListNode = ListNode(val: 0)
    var
        p = l1
        q = l2
        curr = head
    var carry = 0
    while not q.isNil or not q.isNil:
        var x = if p != nil: p.val else: 0
        var y = if q != nil: q.val else: 0
        var sum = carry + x + y
        carry = int sum / 10
        curr.next = ListNode(val:sum mod 10)
        echo "curr[]"
        echo curr[]
        curr = curr.next
        if p != nil: p = p.next
        if q != nil: q = q.next
    if carry > 0:
        curr.next = ListNode(val:carry)
    return head.next

var l1 = ListNode(val: 1)
var l2 = ListNode(val: 2)
var l3=ListNode(val:1,next:ListNode(val:2,next:ListNode(val:3)))
echo addTwoNumbers(l1, l3)





