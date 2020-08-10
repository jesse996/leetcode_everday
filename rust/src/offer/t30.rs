struct MinStack {
    A: Vec<i32>,
    B: Vec<i32>,
}

/**
 * Your MinStack object will be instantiated and called as such:
 * let obj = MinStack::new();
 * obj.push(x);
 * obj.pop();
 * let ret_3: i32 = obj.top();
 * let ret_4: i32 = obj.min();
 */
/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MinStack {
    /** initialize your data structure here. */
    fn new() -> Self {
        Self {
            A: vec![],
            B: vec![],
        }
    }

    fn push(&mut self, x: i32) {
        self.A.push(x);
        match self.B.last() {
            Some(&last) => if last >= x { self.B.push(x) },
            None => self.B.push(x),
        };
    }

    fn pop(&mut self) {
        let pop=self.A.pop().unwrap();
        if pop==*self.B.last().unwrap() {
            self.B.pop().unwrap();
        }
    }

    fn top(&self) -> i32 {
        *self.A.last().unwrap()
    }

    fn min(&self) -> i32 {
        *self.B.last().unwrap()
    }
}

