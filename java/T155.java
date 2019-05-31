import java.util.*;

// 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

// push(x) -- 将元素 x 推入栈中。
// pop() -- 删除栈顶的元素。
// top() -- 获取栈顶元素。
// getMin() -- 检索栈中的最小元素。
// 示例:

// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.

//一个栈，每次push2个，第2个是最小的数
class MinStack {

  /** initialize your data structure here. */
  private Stack<Integer> stack;

  public MinStack() {
    this.stack = new Stack<Integer>();
  }

  public void push(int x) {
    if (this.stack.empty()) {
      this.stack.push(x);
      this.stack.push(x);
    } else {
      int tmp = this.stack.peek();
      this.stack.push(x);
      if (tmp > x) {
        this.stack.push(x);
      } else {
        this.stack.push(tmp);
      }
    }
  }

  public void pop() {
    this.stack.pop();
    this.stack.pop();
  }

  public int top() {

    return this.stack.get(this.stack.size() - 2);
  }

  public int getMin() {
    return this.stack.peek();
  }

  public static void main(String[] args) {
    MinStack a = new MinStack();
    // a.push(-1);
    // a.push(0);
    // a.push(-3);
    // System.out.println(a.getMin());
    // a.pop();
    // System.out.println(a.top());
    System.out.println(Integer.MAX_VALUE == Integer.MAX_VALUE);

  }
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/