class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }else{
                nums[i]=1;
            }
        }


        //this becomes count of subarray with sum k;

        int count=0;
        int prefixSum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // count of subarrays with sum 0
        map.put(0,1);
        for(int i=0;i<n;i++){
            
            prefixSum+=nums[i];

            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}