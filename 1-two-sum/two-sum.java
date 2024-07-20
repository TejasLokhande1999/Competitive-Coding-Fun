class Solution {
    public int[] twoSum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int retArr[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(k-nums[i])){     //we have the target-ele
                retArr[0] = map.get(k-nums[i]);
                retArr[1] = i;

                return retArr;

            }

            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }

        return retArr;
       
    }
}