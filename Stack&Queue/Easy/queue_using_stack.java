import java.util.Stack;
// Problem link: https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue {
    // Optimal - tc: O(1) sc: O(2n)
    public MyQueue() {
    }
    Stack<Integer> input=new Stack<>();
    Stack<Integer> output=new Stack<>();
    
    public void push(int x) {
        input.add(x);
    }
    
    public int pop() {
         if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        int x = output.peek();
        output.pop();
        return x;
    }
    
    public int peek() {
       if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }
    
    public boolean empty() {
        return (input.isEmpty() && output.isEmpty());
    }
}
