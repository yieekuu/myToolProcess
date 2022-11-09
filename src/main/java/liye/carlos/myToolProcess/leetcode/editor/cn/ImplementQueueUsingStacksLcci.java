//实现一个MyQueue类，该类用两个栈来实现一个队列。 
// 示例： MyQueue queue = new MyQueue(); queue.push(1); queue.push(2); queue.peek()
//;  // 返回 1 queue.pop();   // 返回 1 queue.empty(); // 返回 false 说明： 
// 
// 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。 
//
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。 
// 
//
// Related Topics 栈 设计 队列 👍 63 👎 0


package liye.carlos.myToolProcess.leetcode.editor.cn;

import java.util.Stack;

public class ImplementQueueUsingStacksLcci {
    public static void main(String[] args) {
        MyQueue solution = new ImplementQueueUsingStacksLcci().new MyQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        private final Stack<Integer> input;
        private final Stack<Integer> output;
//        private volatile int lock = 0;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            this.input = new Stack<>();
            this.output = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            input.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (output.isEmpty()) {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (output.isEmpty()) {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}