package Tries.Medium;
// Problem link: https://leetcode.com/problems/implement-trie-prefix-tree/
class Node{
    Node links[]=new Node[26];
    boolean flag;
    public Node(){
    }
    boolean containsKey(char ch){
        return (links[ch-'a']!=null);
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
class Trie {
    private static Node root;
    public Trie() {
        root= new Node();
    }
    
    // tc - O(len) sc- O(1)
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }
    // tc- O(len) sc- O(1)
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
        }
        if(node.isEnd()) return true;
        return false;
    }
    // tc - O(len) sc - O(1)
    public boolean startsWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node=node.get(prefix.charAt(i));
        }
        return true;
    }
}
