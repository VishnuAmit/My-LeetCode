import java.util.Stack;
// Problem link: https://leetcode.com/problems/implement-queue-using-stacks/
// Using 2 stacks: tc: O(n) sc: O(2n)
// class MyQueue {
//     Stack<Integer> s1=new Stack<>();
//     Stack<Integer> s2=new Stack<>();
//     public MyQueue() {
        
//     }
    
//     public void push(int x) {
//         while(!s1.isEmpty()){
//             s2.add(s1.peek());
//             s1.pop();
//         }
//         s1.add(x);
//         while(!s2.isEmpty()){
//             s1.add(s2.peek());
//             s2.pop();
//         }

//     }
    
//     public int pop() {
//         return s1.pop();
//     }
    
//     public int peek() {
//         return s1.peek();
//     }
    
//     public boolean empty() {
//         return (s1.size()==0);
//     }
// }

class MyQueue {
    // Optimal - tc: O(1) amortized sc: O(2n)
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
