class Solution {

    class Node{
        Map<Character,Node> map = new HashMap<>();
        boolean isEnd = false;
    }

    Node root = new Node();

    public List<String> findWords(char[][] grid, String[] words) {
        List<String> retList = new ArrayList<>();

        if(words.length==0){
            return retList;
        }
        for(String word : words){
            addWord(word);
        }

        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(i,j,grid,visited,root,retList,"");
                    }
                }
            
            return new ArrayList<>(new HashSet<>(retList));
        
    }

    public void addWord(String word){
        Node currNode = root;
        for(char ch : word.toCharArray()){
            currNode.map.putIfAbsent(ch, new Node());
            currNode = currNode.map.get(ch);
        }

        currNode.isEnd = true;

    }

    public void dfs(int i, int j, char[][] grid, boolean visited[][], Node root,List<String> retList, String word){

        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]){
            return;
        }

        char ch = grid[i][j];

        if(!root.map.containsKey(ch)){
            return;
        }

        word+=ch;
        root = root.map.get(ch);

        if(root.isEnd){
            retList.add(word);
        }
        visited[i][j]= true;
        dfs(i+1,j,grid,visited,root,retList,word);
        dfs(i-1,j,grid,visited,root,retList,word);
        dfs(i,j+1,grid,visited,root,retList,word);
        dfs(i,j-1,grid,visited,root,retList,word);
        visited[i][j] = false;


    }
}
