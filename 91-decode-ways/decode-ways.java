class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];

        Arrays.fill(dp,-1);

        return func(s,0,dp);
    }

    public int func(String s, int i, int dp[]){

        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int count =0;
        count+=func(s,i+1,dp);

        if(i<s.length()-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<'7' ) ){
            count+=func(s,i+2,dp);
        }
        dp[i] = count;

        return dp[i];


    }
}