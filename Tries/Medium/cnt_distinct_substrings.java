package Tries.Medium;
// Problem link: https://www.codingninjas.com/studio/problems/count-distinct-substrings_985292?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Node{
	Node links[]=new Node[26];
	boolean containsKey(char ch){
		return (links[ch-'a']!=null);
	}
	void put(char ch, Node node){
		links[ch-'a']=node;
	}
	Node get(char ch){
		return links[ch-'a'];
	}
}

class Solution 
{
	public static int countDistinctSubstrings(String s) 
	{
		// // Brute force - tc: O(logm*n2) sc: O(n3)
		// Set<String> st=new HashSet<>();
		// for(int i=0;i<s.length();i++){
		// 	String str="";
		// 	for(int j=i;j<s.length();j++){
		// 		str=str+s.charAt(j);
		// 		st.add(str);
		// 	}
		// }
		// return st.size()+1;

		// Optimal - tc: O(n2) sc: cant predict
		int n=s.length();
		int cnt=0;
		Node root=new Node();
		for(int i=0;i<n;i++){
			Node node=root;
			for(int j=i;j<n;j++){
				if(!node.containsKey(s.charAt(j))){
					node.put(s.charAt(j), new Node());
					cnt++;
				}
				node=node.get(s.charAt(j));
			}
		}
		return cnt+1;
	}
}
