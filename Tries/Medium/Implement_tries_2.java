package Tries.Medium;
// Problem link: https://www.codingninjas.com/studio/problems/trie-delete-operation_1062663?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Node{
    Node links[]=new Node[26];
    int cntendwith=0;
    int cntprefix=0;

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
    void inc_end(){
        cntendwith++;
    }
    void inc_prefix(){
        cntprefix++;
    }
    void dec_end(){
        cntendwith--;
    }
    void dec_prefix(){
        cntprefix--;
    }
    int getend(){
        return cntendwith;
    }
    int getprefix(){
        return cntprefix;
    }

} 
class Trie {
    // tc - O(n) sc- O(1)
    public static Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node=node.get(word.charAt(i));
            node.inc_prefix();
        }
        node.inc_end();
    }

    public int countWordsEqualTo(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getend();
    }

    public int countWordsStartingWith(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getprefix();
    }

    public void erase(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
                node.dec_prefix();
            }else{
                return;
            }
        }
        node.dec_end();
    }

}

