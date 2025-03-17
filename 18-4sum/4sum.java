class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<>();
        if(nums.length<4){
            return retList;
        }
        Set<String> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n-3;i++){

            for(int j=i+1;j<n-2;j++){

            int k=j+1;
            int l = n-1;
            
            List<Integer> list = new ArrayList<>();
            while(k<l){
            
                long temp = (long) nums[i] + nums[j] + nums[k] + nums[l];
                if(temp<target){
                    k++;
                }else if(temp>target){
                    l--;
                }else{
                    //temp == target
                     // Found a quadruplet
                     String str = String.valueOf(nums[i])+String.valueOf(nums[j])+String.valueOf(nums[k])+String.valueOf(nums[l]);

                        if(!set.contains(str))
                        {
                        retList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        set.add(str);
                            // Skip duplicates for k
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        // Skip duplicates for l
                        while (k < l && nums[l] == nums[l - 1]) l--;
                        }
                        
                        k++;
                        l--;;
                }

            }

            }
            
        }

        return retList;

    }
}