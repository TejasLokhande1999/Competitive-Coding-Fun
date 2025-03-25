class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(0,s);
    }

    public int dfs(int i, String s){

        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int count = 0;
        count = dfs(i+1,s);

        if(i<s.length()-1 && (s.charAt(i)=='1' || (s.charAt(i)=='2'&& s.charAt(i+1)<'7'))){
            count+=dfs(i+2,s);
        }

        return dp[i] = count;


    }
}