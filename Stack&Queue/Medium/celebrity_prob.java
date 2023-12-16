// Problem link: https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    //     // Brute force - tc: O(n) sc: O(n)
    // 	Stack<Integer> st=new Stack<>();
    // 	for(int i=0;i<n;i++){
    // 	    st.push(i);
    // 	}
    // 	while(st.size()>=2){
    // 	    int i=st.pop();
    // 	    int j=st.pop();
    // 	    if(M[i][j]==1){
    // 	        st.push(j);
    // 	    }else{
    // 	        st.push(i);
    // 	    }
    // 	}
    	
    // 	  int pot = st.pop();
    //     for (int i = 0; i < n; i++) {
    //         if (i != pot) { // Fixed the loop condition
    //             if (M[i][pot] == 0 || M[pot][i] == 1) {
    //                 return -1;
    //             }
    //         }
    //     }
    //     return pot;
    
        
       // Optimal - tc: O(n) sc: O(1)
        int celeb = 0;
        for (int i = 1; i < n; i++) {
            if (M[celeb][i] == 1)
                celeb = i;
        }

        for (int i = 0; i < n; i++) {
            if (i != celeb && (M[celeb][i] == 1 || M[i][celeb] == 0))
                return -1;
        }

        return celeb;
    }
}