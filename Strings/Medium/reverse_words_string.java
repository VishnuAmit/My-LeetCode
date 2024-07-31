// Problem link: https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public void reverse(char[] arr, int start, int end){
        while(start<=end){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        // // Brute force - tc: O(n) sc: O(n)
        // Stack<String> st=new Stack<>();
        // String temp="";
        // String ans="";
        // s+=" ";
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)!= ' '){
        //         temp+=s.charAt(i);
        //     }else{
        //         if(!temp.isEmpty()){
        //         st.push(temp);
        //         temp="";
        //         }
        //     }
        // } 

        // while(st.size()!=1){
        //     ans+=st.peek()+" ";
        //    st.pop();
        // }
        // ans+=st.peek();
        // return ans;

        // Optimal - tc: O(n) sc: O(1)
        s=s.trim().replaceAll(" +"," ");
        
        char[] arr=s.toCharArray();

        reverse(arr,0,s.length()-1);

        int st=0;
        for(int end=0;end<=arr.length;end++){
            if(end==arr.length || arr[end]==' ' ){
                reverse(arr,st,end-1);
                st=end+1;
            }
        }
        return new String(arr);
    }
}