import java.util.*;
// Problem link: https://leetcode.com/problems/implement-stack-using-queues/
class MyStack {
    // tc - O(n) sc: O(n)
    public MyStack() {
    }
    Queue<Integer> q=new LinkedList<>();
    
    public void push(int x) {
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            q.add(q.peek());
            q.poll();
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return (q.size()==0);
    }
}