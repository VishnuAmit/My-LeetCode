package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;
// Problem link: https://www.codingninjas.com/studio/problems/920438?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
class Solution {
	public static int revInorder(TreeNode  root, int [] visCount, int k)
	{
		if (root == null)
		{
			return -1;
		} 
		int right = revInorder(root.right, visCount, k);
	    if (right != -1)
	    {
	    	return right;
	    }
		visCount[0]++;
		if (visCount[0] == k)
		{
			return root.val;
		}
		int left = revInorder(root.left, visCount, k);
	    
	    return left;
	}


	public static int KthLargestNumber(TreeNode root, int k) {
        // Optimal - tc: O(n) sc: O(1)
		int[] visCount = new int [1];
		return revInorder(root, visCount, k);
	}
}