// Problem link: https://leetcode.com/problems/online-stock-span/
import java.util.Stack;
class StockSpanner {
    Stack<int[]> s;
    public StockSpanner() {
        s=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!s.isEmpty() && s.peek()[0]<=price){
            span+=s.peek()[1];
            s.pop();
        }
        s.push(new int[]{price, span});
        return span;
    }
}
