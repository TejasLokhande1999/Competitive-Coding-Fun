class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int retArr[] = new int[2];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                retArr[0] = i;
                retArr[1] = map.get(target-nums[i]);
                return retArr;
            }

            map.put(nums[i], i);
        }

        return retArr;
    }
}