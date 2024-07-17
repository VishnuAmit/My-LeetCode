import java.util.*;
// Problem link: https://leetcode.com/problems/implement-stack-using-queues/
class MyStack {
    // tc - O(n) sc: O(n)
    // Queue<Integer> q1=new LinkedList<>();
    // Queue<Integer> q2=new LinkedList<>();
    public MyStack() {
    }
    Queue<Integer> q=new LinkedList<>();
    
    public void push(int x) {
        // 2 queues - tc: O(n) sc: O(2n)
        // q2.add(x);
        // while(!q1.isEmpty()){
        //   q2.add(q1.peek());
        //   q1.poll();
        // } 
        // Queue temp=q2;
        // q2=q1;
        // q1=temp;
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