class Solution {
    public int getLargestOutlier(int[] nums) {
        int totalSum=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int maxOutlier = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            int x = nums[i];

            int potentialOutlier = totalSum - 2*x;

            if(map.containsKey(potentialOutlier)){
                
                if(potentialOutlier==nums[i] && map.get(potentialOutlier)>=2){
                    maxOutlier = Math.max(maxOutlier,potentialOutlier);
                }else if(potentialOutlier!=nums[i]){
                    maxOutlier = Math.max(maxOutlier,potentialOutlier);

                }

            }

        }

        return maxOutlier;
     

    }
}