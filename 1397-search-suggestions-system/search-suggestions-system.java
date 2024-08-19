class Trie{

    static class Node{
        Map<Character, Node> map = new HashMap<>();
        List<String> list = new ArrayList<>();
    }

    private Node root;

    Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node currNode = root;

        for(char ch : word.toCharArray()){
            if(!currNode.map.containsKey(ch)){
                currNode.map.put(ch, new Node());
            }

            //go to the next node
            currNode = currNode.map.get(ch);
            //now add the string to list
            if(currNode.list.size()<3)
                currNode.list.add(word);
        }
    }

    public List<String> search(String word){

        Node currNode = root;
        for(char ch: word.toCharArray()){
            if(!currNode.map.containsKey(ch)){
                return new ArrayList<>();
            }

            currNode = currNode.map.get(ch);
        }

        //now we have traced the prefix, now sort the list and retirn

        Collections.sort(currNode.list);
        return currNode.list;
    }

}

class Solution {


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        Trie trie = new Trie();
        for(String product : products){
            trie.insert(product);
        }

        String prefix="";
        List<List<String>> retList = new ArrayList<>();
        for(char ch : searchWord.toCharArray()){
            prefix+=ch;
            List<String> list = trie.search(prefix);

            retList.add(list);
        }

        return retList;

    }
}

