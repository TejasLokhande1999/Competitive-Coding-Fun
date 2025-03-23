class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int lgt = triangle.size();
        int n =  triangle.get(lgt-1).size();


        int dp[] = new int[n+1];

        List<Integer> list = triangle.get(lgt-1);

        for(int i=0;i<n;i++){
            dp[i] = list.get(i);
        } 

        for(int i=lgt-2;i>=0;i--){
            List<Integer> tempList = triangle.get(i);

            for(int j=0;j<tempList.size();j++){
                dp[j] = tempList.get(j) + Math.min(dp[j],dp[j+1]);
            }
        }

        return dp[0];



            

            

    }
}