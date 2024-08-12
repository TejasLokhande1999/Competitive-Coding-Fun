class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int t[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                t[i][j]=-1;
            }
        }
        return LCS(text1,text2,m,n,t);
        
    }

    public int LCS(String X, String Y, int m, int n, int t[][]){
        if(m==0 || n==0){
            return 0;
        }
        if(t[m][n]!=-1){
            return t[m][n];
        }

        if(X.charAt(m-1)==Y.charAt(n-1)){
            return t[m][n] = 1+LCS(X,Y,m-1,n-1,t);
        }else{
            return t[m][n] = Math.max(LCS(X,Y,m-1,n,t), LCS(X,Y,m,n-1,t));
        }
    }
}