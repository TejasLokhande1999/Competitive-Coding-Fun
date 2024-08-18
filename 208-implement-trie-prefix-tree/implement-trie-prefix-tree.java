class Trie {

    private Node root;
    public Trie() {
        //Empty root node
        root = new Node();
    }
    
    public void insert(String word) {
        Node currNode = root;

        for(char ch : word.toCharArray()){
            if(!currNode.map.containsKey(ch)){
                currNode.map.put(ch, new Node());
            }
            currNode = currNode.map.get(ch);
        }
        currNode.isEndOfWord = true;
    }
    
    public boolean search(String word) {

        Node currNode = root;

        for(char ch : word.toCharArray()){
            if(!currNode.map.containsKey(ch))
                return false;

            //Move to next node
            currNode = currNode.map.get(ch);
        }

        return currNode.isEndOfWord;

    }
    
    public boolean startsWith(String prefix) {
        
        Node currNode = root;

        for(char ch : prefix.toCharArray()){

            if(!currNode.map.containsKey(ch)){
                return false;
            }

            currNode = currNode.map.get(ch);

        }

        //we are done tracing the prefix,, so we can return true
        return true;

    }
}

class Node{
    Map<Character, Node> map = new HashMap<>();
    boolean isEndOfWord = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */