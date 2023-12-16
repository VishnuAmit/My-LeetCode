// Problem link: https://www.codingninjas.com/studio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
import java.util.Stack;

class Solution {

	public static void stackmerge(Stack<Integer> stack, int current){
		if(stack.isEmpty() || current>stack.peek()){
			stack.push(current);
			return;
		}
		int top=stack.peek();
		stack.pop();
		stackmerge(stack,current);
		stack.push(top);
	}
	public static void sortStack(Stack<Integer> stack) {
		// tc - O(n2) sc: O(n)
		if(stack.isEmpty()) return;
		int top=stack.peek();
		stack.pop();
		sortStack(stack);
		stackmerge(stack, top);
	}

}