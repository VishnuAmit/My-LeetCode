package Tries.Hard;
// Problem link: https://www.codingninjas.com/studio/problems/longest-common-prefix_2090383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Node{
  Node links[]=new Node[26];
  boolean flag=false;
  public Node(){

  }
  boolean containsKey(char ch){
    return(links[ch-'a']!=null);
  }
  void put(char ch, Node node){
    links[ch-'a']=node;
  }
  Node get(char ch){
    return links[ch-'a'];
  }
  void setEnd(){
    flag=true;
  }
  boolean isEnd(){
    return flag;
  }
}

class Trie{
  private static Node root;
  Trie(){
    root=new Node();
  }
  public static void insert(String word){
    Node node=root;
    for(int i=0;i<word.length();i++){
      if(!node.containsKey(word.charAt(i))){
        node.put(word.charAt(i),new Node());
      }
      node=node.get(word.charAt(i));
    }
    node.setEnd();
  }
  boolean checkifprefixexists(String word){
    Node node=root;
    boolean flag=true;
    for(int i=0;i<word.length();i++){
      if(node.containsKey(word.charAt(i))){
        node=node.get(word.charAt(i));
        if(node.isEnd()==false) return false;
      }else{
      return false;
      }

    }
    return true;
  }
}
class Solution {
  public static String completeString(int n, String[] a) {
    // tc - O(2n*len) sc - cant predict
    Trie obj=new Trie();
    for(int i=0;i<n;i++){
      obj.insert(a[i]);
    }
    String longest="";
    for(int i=0;i<n;i++){
      if(obj.checkifprefixexists(a[i])){
        if(a[i].length()>longest.length()){
          longest=a[i];
        }else if(a[i].length()==longest.length() && a[i].compareTo(longest)<0){
          longest=a[i];
        }
      }
    }
    if(longest=="") return "None";
    return longest;
  }
}