class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int length = triangle.size();
        int n = triangle.get(length-1).size();

        int dp[] = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = triangle.get(length-1).get(i);
        }


        for(int i=length-2;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for(int j=0;j<list.size();j++){
                dp[j] = list.get(j) + Math.min(dp[j],dp[j+1]);
            }
        }

        return dp[0];
    }
}