import java.util.* ;
import java.io.*; 
// Problem link: https://www.codingninjas.com/codestudio/problems/merge-k-sorted-arrays_975379
class Pair{
	public int first,second,third;
	Pair(int first,int second,int third){
		this.first=first; // el
		this.second=second; // arr ind
		this.third=third; // ind within arr
	}
}

class pqcomparator implements Comparator<Pair>{
	public int compare(Pair pair1, Pair pair2){
		if(pair1.first<pair2.first){
			return -1;
		}else if(pair1.first==pair2.first) return 0;
		else return 1;
	}
}

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// // Brute force - O(nk*lognk) sc: O(nk)
		// ArrayList<Integer> ans = new ArrayList<>();
        // for (int i = 0; i < k; i++) {
        //     ans.addAll(kArrays.get(i));
        // }
        // Collections.sort(ans);
        // return ans;

		// Optimal - tc: O(nk*logk) sc: O(nk)
		ArrayList<Integer> ans=new ArrayList<>();
		PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new pqcomparator());
		for(int i=0;i<kArrays.size();i++){
			pq.add(new Pair(kArrays.get(i).get(0),i,0));
		}
		while(!pq.isEmpty()){
			Pair cur=pq.remove();
			int i=cur.second;
			int j=cur.third;
			
			ans.add(cur.first);

			if(j+1<kArrays.get(i).size()){
				pq.add(new Pair(kArrays.get(i).get(j+1),i,j+1));
			}
		}
		return ans;
	}
}
