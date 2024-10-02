class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n<=0){
            return res;
        }
        List<String> curr = new ArrayList<>();

        //3 hashsets;
        HashSet<Integer> colSet = new HashSet<>();
        HashSet<Integer> posDiag = new HashSet<>();
        HashSet<Integer> negDiag = new HashSet<>();

        dfs(n,colSet,posDiag,negDiag,curr);

        return res;

    }

    public void dfs(int n, HashSet<Integer> colSet, HashSet<Integer> posDiag, HashSet<Integer> negDiag,List<String> curr){

        if(curr.size()==n){
            res.add(new ArrayList<>(curr));
            return;
        }
    
    int row = curr.size();

    for(int col=0;col<n;col++){

        if(colSet.contains(col) || negDiag.contains(row-col)|| posDiag.contains(row+col)){
            continue;
        }else{

            String s = convert(n,col);
            curr.add(s);
            colSet.add(col);
            posDiag.add(row+col);
            negDiag.add(row-col);

            dfs(n,colSet,posDiag,negDiag,curr);

            //backtrack
            curr.remove(curr.size()-1);
            colSet.remove(col);
            posDiag.remove(row+col);
            negDiag.remove(row-col);

        }


    }


    }

    public String convert(int n, int col){
            StringBuilder str = new StringBuilder();

            for(int i=0;i<n;i++){
                if(i==col){
                    str.append("Q");
                }else{
                    str.append(".");
                }
            }

            return str.toString();

    }
}