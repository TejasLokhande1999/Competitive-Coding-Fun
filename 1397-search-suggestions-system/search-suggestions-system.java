class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie obj = new Trie();
        for(String product : products){
            obj.insert(product);
        }

        List<List<String>> retList = new ArrayList<>();

        for(int i=0;i<searchWord.length();i++){
            String src = searchWord.substring(0,i+1);
            List<String> str = obj.search(src);
            retList.add(str);
        }

        return retList;

    }
}
class Trie{

    static class Node{
        Map<Character, Node> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
    }

    Node root;
    Trie(){
        root=new Node();
    }


    public void insert(String word){
        Node currNode = root;

        for(char ch : word.toCharArray()){
            if(!currNode.map.containsKey(ch)){
                currNode.map.put(ch, new Node());
            }
            currNode = currNode.map.get(ch);    //go to the new node
            if(currNode.list.size()<3){
                currNode.list.add(word);
            }
        }
    }

    public List<String> search(String word){
                Node currNode = root;

        for(char ch : word.toCharArray()){
            if(!currNode.map.containsKey(ch)){
                return new ArrayList<>();
            }
            currNode = currNode.map.get(ch);
        }

        return currNode.list;
    }
}