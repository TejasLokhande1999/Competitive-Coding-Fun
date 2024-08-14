class Solution {
    public int subarraySum(int[] nums, int k) {
        // int count=0;

        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        // int currSum=0;
        // for(int i=0;i<nums.length;i++){
        //     currSum+=nums[i];

        //     if(map.containsKey(currSum-k)){
        //         count += map.get(currSum-k);
        //     }
        //     map.put(currSum, map.getOrDefault(currSum,0)+1);
        // }

        // return count;

    int count=0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){

                sum+=nums[j];
                if(sum==k){
                    count+=1;
                }
                
            }
        }


        return count;

    }
}