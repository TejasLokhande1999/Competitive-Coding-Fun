class Solution {

    static class Node{
        Map<Character,Node> map = new HashMap<>();
        boolean isEndOfWord = false;
        List<String> list = new ArrayList<>();
    }
    Node root = new Node();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> retList = new ArrayList<>();
        Arrays.sort(products);
        for(String product : products){
            insert(product);
        }

        String pre="";
        for(char ch : searchWord.toCharArray()){
            pre+=ch;
            retList.add(search(pre));
        }

        return retList;

    }

    public List<String> search(String pre){

        Node curr = root;

        for(char ch : pre.toCharArray()){

            if(!curr.map.containsKey(ch)){
                return new ArrayList<>();
            }
            curr =curr.map.get(ch);
        }

        return curr.list;
    }

    public void insert(String word){

        Node currNode = root;

        for(char ch : word.toCharArray()){

            if(!currNode.map.containsKey(ch)){
                currNode.map.put(ch,new Node());
                
            }
            currNode = currNode.map.get(ch);
             if(currNode.list.size()<3){
                    currNode.list.add(word);
                }
        }

        currNode.isEndOfWord = true;

    }
}