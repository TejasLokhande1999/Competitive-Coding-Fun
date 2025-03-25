class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // List<Integer> retList = new ArrayList<>();

        // int n = nums.length;

        // Set<Integer> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     set.add(nums[i]);
        // }

        // for(int i=1;i<=n;i++){

        //     if(!set.contains(i)){
        //         retList.add(i);
        //     }
        // }

        // return retList;

        int n = nums.length;
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]);
            if(!(nums[idx-1]<0)){
                nums[idx-1]*=-1;
            }
        }

        List<Integer> retList = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                retList.add(i+1);
            }
        }

        return retList;

    }
}