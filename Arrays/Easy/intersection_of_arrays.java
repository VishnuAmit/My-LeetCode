package Easy;
import java.util.* ;
// Problem link: https://www.codingninjas.com/studio/problems/intersection-of-2-arrays_1082149?leftPanelTabValue=PROBLEM
class Solution
{
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m){
		// // Brute force - tc: O(mn) sc: O(m)
		// int [] visited = new int[m]; // m - smaller array
		// ArrayList<Integer> ans = new ArrayList<>();
		// for(int i=0;i<arr1.size();i++){
		// 	for(int j=0;j<arr2.size();j++){
		// 		if(arr1.get(i)==arr2.get(j) && visited[j]==0){
		// 			ans.add(arr2.get(j));
		// 			visited[j]=1;
		// 			break;
		// 		}else if(arr2.get(j)>arr1.get(i)){
		// 			break;
		// 		}
		// 	}
		// }
		// return ans;

		// Optimal - tc: O(n1+n2) sc: O(n1+n2) -> to return the ans
		ArrayList<Integer> ans = new ArrayList<>();
		int i=0,j=0;
		while(i<n && j<m){
			if(arr1.get(i)<arr2.get(j)){
				i++;
			}else if(arr1.get(i)>arr2.get(j)){
				j++;
			}else{
				ans.add(arr1.get(i));
				i++;
				j++;
			}
		}
		return ans;
	}
}

