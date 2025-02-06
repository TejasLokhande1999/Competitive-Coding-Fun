class Solution {
    public List<String> generateParenthesis(int n) {
        int close =0;
        int open = 0;

        List<String> res = new ArrayList<>();
        String str="";
        backtrack(open,close,n,res,str);
        return res;
    }

    public void backtrack(int open, int close, int n, List<String> res, String str){

        if(open==n && close==n){
            res.add(str);
            return;
        }

        if(open<n){
            str+='(';
            backtrack(open+1,close,n,res,str);
            str = str.substring(0,str.length()-1);
        }

        if(close<open){
            str+=')';
            backtrack(open,close+1,n,res,str);
            str = str.substring(0,str.length()-1);
        }

    }
}