class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> retList = new ArrayList<>();

        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int i=1;i<=n;i++){

            if(!set.contains(i)){
                retList.add(i);
            }
        }



        return retList;
    }
}