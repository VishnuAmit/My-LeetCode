// Problem link: https://leetcode.com/problems/min-stack/
import java.util.Stack;

// Brute force - tc: O(1) sc: O(2n)
// class Pair{
//     int x,y;
//     public Pair(int x, int y){
//         this.x=x;
//         this.y=y;
//     }
// }


class MinStack {
    //     Stack<Pair> st;
    //     public MinStack(){
    //         st=new Stack<>();
    // }
    
    // Optimal - tc: O(1) sc: O(n)
    Stack<Long> st=new Stack<>();
    Long min=Long.MAX_VALUE;
    
    public void push(int val) {
        // int min;
        // if(st.isEmpty()) min=val;
        // else{
        //     min=Math.min(st.peek().y, val);
        // }
        // st.push(new Pair(val,min));

        Long value=Long.valueOf(val);
        if(st.isEmpty()){
            min=value;
            st.push(value);
        }else{
            if(value<min){
                st.push(2*value-min);
                min=value;
            }else{
                st.push(value);
            }
        }
    }
    
    public void pop() {
        // st.pop();
        if(st.isEmpty()) return;
        Long value=st.pop();
        if(value<min){
            min=2*min-value;
        }
    }
    
    public int top() {
        // return st.peek().x; 
        Long value=st.peek();
        if(value<min) return min.intValue();
        else return value.intValue();
    }
    
    public int getMin() {
        // return st.peek().y;
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */