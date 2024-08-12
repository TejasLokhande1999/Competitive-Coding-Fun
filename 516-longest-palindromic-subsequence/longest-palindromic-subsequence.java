class Solution {
    public int longestPalindromeSubseq(String s) {
        
        String s2 ="";

        for(int i=s.length()-1;i>=0;i--){
            s2+=s.charAt(i);
        }

        int m = s.length();
        int n = s2.length();

        int t[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                t[i][j]=-1;
            }
        }

        return LCS(s,s2,m,n,t);
    }

    public int LCS(String X, String Y, int m, int n, int t[][]){

        if(m==0 || n==0){
            return 0;
        }

        if(t[m][n]!=-1){
            return t[m][n];
        }

        if(X.charAt(m-1)==Y.charAt(n-1)){
           return t[m][n] = 1+ LCS(X,Y,m-1,n-1,t);
        }else{
           return t[m][n] =  Math.max(LCS(X,Y,m-1,n,t),LCS(X,Y,m,n-1,t));
        }

    }
}