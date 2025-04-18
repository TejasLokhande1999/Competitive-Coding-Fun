class Solution {
    class TrieNode{
        Map<Character,TrieNode> map = new HashMap<>();
        boolean isEof=false;
    }

    TrieNode root;

    public String longestCommonPrefix(String[] strs) {
        root = new TrieNode();
        Arrays.sort(strs);
        for(String str : strs){
            insert(str);
        }
        String smallestStr = strs[0];

        String retStr = getLongestPrefix(smallestStr);

        return retStr;
    }


    public void insert(String str){

        TrieNode curr = root;

        for(char ch : str.toCharArray()){

            if(!curr.map.containsKey(ch)){
                curr.map.put(ch, new TrieNode());
            }
            curr = curr.map.get(ch);
        }
        curr.isEof = true;

    }

    public String getLongestPrefix(String str){
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();
        for(char ch : str.toCharArray()){

            if(curr.map.size()==1){
                prefix.append(ch);
                curr = curr.map.get(ch);
            }else{
                return prefix.toString();
            }

        }

        return prefix.toString();

    }
}