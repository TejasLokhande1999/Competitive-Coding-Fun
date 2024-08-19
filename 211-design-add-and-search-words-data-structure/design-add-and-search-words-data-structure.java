class WordDictionary {

    static class Node{
        Map<Character, Node>map = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node currNode = root;
        for(char ch: word.toCharArray()){
            if(!currNode.map.containsKey(ch)){
                currNode.map.put(ch, new Node());
            }

            currNode = currNode.map.get(ch);
        }

        currNode.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    public boolean searchInNode(String word,Node currNode){
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(ch=='.'){
                //search for all possibilities
                for(Node node : currNode.map.values()){
                    if(searchInNode(word.substring(i+1),node)){
                        return true;
                    }
                }
                return false;
                
            }else{
                if(!currNode.map.containsKey(ch)){
                    return false;
                }
                currNode = currNode.map.get(ch);
            }
        }

        return currNode.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */